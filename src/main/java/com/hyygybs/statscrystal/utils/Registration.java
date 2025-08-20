package com.hyygybs.statscrystal.utils;

import com.hyygybs.statscrystal.item.*;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static com.hyygybs.statscrystal.StatsCrystal.MODID;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MODID);

    public static final RegistryObject<Codec<DropModifier>> CRYSTAL_DROP = LOOT_MODIFIERS.register("crystal_drop", () -> DropModifier.CODEC);

    public static final RegistryObject<Block> HEART_CRYSTAL_ORE = BLOCKS.register("heart_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_HEART_CRYSTAL_ORE = BLOCKS.register("deepslate_heart_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> POWER_CRYSTAL_ORE = BLOCKS.register("power_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_POWER_CRYSTAL_ORE = BLOCKS.register("deepslate_power_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> GUARD_CRYSTAL_ORE = BLOCKS.register("guard_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_GUARD_CRYSTAL_ORE = BLOCKS.register("deepslate_guard_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> TOUGH_CRYSTAL_ORE = BLOCKS.register("tough_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_TOUGH_CRYSTAL_ORE = BLOCKS.register("deepslate_tough_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> SPEED_CRYSTAL_ORE = BLOCKS.register("speed_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_SPEED_CRYSTAL_ORE = BLOCKS.register("deepslate_speed_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> LUCK_CRYSTAL_ORE = BLOCKS.register("luck_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_LUCK_CRYSTAL_ORE = BLOCKS.register("deepslate_luck_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> LIFE_CRYSTAL_ORE = BLOCKS.register("life_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Block> DEEPSLATE_LIFE_CRYSTAL_ORE = BLOCKS.register("deepslate_life_crystal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3, 15)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            )
    );

    public static final RegistryObject<Item> HEART_CRYSTAL_ORE_ITEM = ITEMS.register("heart_crystal_ore", () -> new BlockItem(HEART_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_HEART_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_heart_crystal_ore", () -> new BlockItem(DEEPSLATE_HEART_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> POWER_CRYSTAL_ORE_ITEM = ITEMS.register("power_crystal_ore", () -> new BlockItem(POWER_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_POWER_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_power_crystal_ore", () -> new BlockItem(DEEPSLATE_POWER_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> GUARD_CRYSTAL_ORE_ITEM = ITEMS.register("guard_crystal_ore", () -> new BlockItem(GUARD_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_GUARD_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_guard_crystal_ore", () -> new BlockItem(DEEPSLATE_GUARD_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOUGH_CRYSTAL_ORE_ITEM = ITEMS.register("tough_crystal_ore", () -> new BlockItem(TOUGH_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_TOUGH_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_tough_crystal_ore", () -> new BlockItem(DEEPSLATE_TOUGH_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPEED_CRYSTAL_ORE_ITEM = ITEMS.register("speed_crystal_ore", () -> new BlockItem(SPEED_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_SPEED_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_speed_crystal_ore", () -> new BlockItem(DEEPSLATE_SPEED_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LUCK_CRYSTAL_ORE_ITEM = ITEMS.register("luck_crystal_ore", () -> new BlockItem(LUCK_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_LUCK_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_luck_crystal_ore", () -> new BlockItem(DEEPSLATE_LUCK_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIFE_CRYSTAL_ORE_ITEM = ITEMS.register("life_crystal_ore", () -> new BlockItem(LIFE_CRYSTAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_LIFE_CRYSTAL_ORE_ITEM = ITEMS.register("deepslate_life_crystal_ore", () -> new BlockItem(DEEPSLATE_LIFE_CRYSTAL_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> HEART_CRYSTAL = ITEMS.register("heart_crystal", () -> new HeartCrystal(new Item.Properties()));
    public static final RegistryObject<Item> HEART_CRYSTAL_SHARD = ITEMS.register("heart_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWER_CRYSTAL = ITEMS.register("power_crystal", () -> new PowerCrystal(new Item.Properties()));
    public static final RegistryObject<Item> POWER_CRYSTAL_SHARD = ITEMS.register("power_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUARD_CRYSTAL = ITEMS.register("guard_crystal", () -> new GuardCrystal(new Item.Properties()));
    public static final RegistryObject<Item> GUARD_CRYSTAL_SHARD = ITEMS.register("guard_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOUGH_CRYSTAL = ITEMS.register("tough_crystal", () -> new ToughCrystal(new Item.Properties()));
    public static final RegistryObject<Item> TOUGH_CRYSTAL_SHARD = ITEMS.register("tough_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPEED_CRYSTAL = ITEMS.register("speed_crystal", () -> new SpeedCrystal(new Item.Properties()));
    public static final RegistryObject<Item> SPEED_CRYSTAL_SHARD = ITEMS.register("speed_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUCK_CRYSTAL = ITEMS.register("luck_crystal", () -> new LuckCrystal(new Item.Properties()));
    public static final RegistryObject<Item> LUCK_CRYSTAL_SHARD = ITEMS.register("luck_crystal_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIFE_CRYSTAL = ITEMS.register("life_crystal", () -> new LifeCrystal(new Item.Properties()));
    public static final RegistryObject<Item> LIFE_CRYSTAL_SHARD = ITEMS.register("life_crystal_shard", () -> new Item(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> STATSCRYSTAL_TAB = CREATIVE_MODE_TABS.register("statscrystal_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("statscrystal.tab"))
                    .icon(() -> new ItemStack(HEART_CRYSTAL.get()))
                    .build());

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
        LOOT_MODIFIERS.register(bus);
        bus.addListener(Registration::buildCreativeTab);
    }

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == STATSCRYSTAL_TAB.getKey()) {
            event.accept(HEART_CRYSTAL_ORE_ITEM);
            event.accept(POWER_CRYSTAL_ORE_ITEM);
            event.accept(GUARD_CRYSTAL_ORE_ITEM);
            event.accept(TOUGH_CRYSTAL_ORE_ITEM);
            event.accept(SPEED_CRYSTAL_ORE_ITEM);
            event.accept(LUCK_CRYSTAL_ORE_ITEM);
            event.accept(LIFE_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_HEART_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_POWER_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_GUARD_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_TOUGH_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_SPEED_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_LUCK_CRYSTAL_ORE_ITEM);
            event.accept(DEEPSLATE_LIFE_CRYSTAL_ORE_ITEM);
            event.accept(HEART_CRYSTAL);
            event.accept(HEART_CRYSTAL_SHARD);
            event.accept(POWER_CRYSTAL);
            event.accept(POWER_CRYSTAL_SHARD);
            event.accept(GUARD_CRYSTAL);
            event.accept(GUARD_CRYSTAL_SHARD);
            event.accept(TOUGH_CRYSTAL);
            event.accept(TOUGH_CRYSTAL_SHARD);
            event.accept(SPEED_CRYSTAL);
            event.accept(SPEED_CRYSTAL_SHARD);
            event.accept(LUCK_CRYSTAL);
            event.accept(LUCK_CRYSTAL_SHARD);
            event.accept(LIFE_CRYSTAL);
            event.accept(LIFE_CRYSTAL_SHARD);
        }
    }
}
