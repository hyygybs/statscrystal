package com.hyygybs.statscrystal.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DropModifier extends LootModifier {
    private final List<WeightedDrop> drops;

    public static final Codec<DropModifier> CODEC = RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst)
            .and(WeightedDrop.CODEC.listOf().fieldOf("drops").forGetter(m -> m.drops))
            .apply(inst, DropModifier::new));

    public DropModifier(LootItemCondition[] conditions, List<WeightedDrop> drops) {
        super(conditions);
        this.drops = drops;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.hasParam(LootContextParams.THIS_ENTITY) &&
                context.getParam(LootContextParams.THIS_ENTITY).getType() != EntityType.PLAYER) {

            int totalWeight = drops.stream().mapToInt(WeightedDrop::weight).sum();
            if (totalWeight <= 0) return generatedLoot;

            int randomValue = context.getRandom().nextInt(totalWeight);
            int currentWeight = 0;
            for (WeightedDrop drop : drops) {
                currentWeight += drop.weight();
                if (randomValue < currentWeight) {
                    generatedLoot.add(drop.createStack(context.getRandom()));
                    break;
                }
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    public record WeightedDrop(Item item, int weight, int minCount, int maxCount) {
        public static final Codec<WeightedDrop> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(WeightedDrop::item),
                Codec.INT.fieldOf("weight").forGetter(WeightedDrop::weight),
                Codec.INT.optionalFieldOf("minCount", 1).forGetter(WeightedDrop::minCount),
                Codec.INT.optionalFieldOf("maxCount", 1).forGetter(WeightedDrop::maxCount)
        ).apply(inst, WeightedDrop::new));

        public ItemStack createStack(RandomSource random) {
            int count;
            if (minCount == maxCount) {
                count = minCount;
            } else {
                count = random.nextIntBetweenInclusive(minCount, maxCount);
            }
            return new ItemStack(item, count);
        }
    }
}
