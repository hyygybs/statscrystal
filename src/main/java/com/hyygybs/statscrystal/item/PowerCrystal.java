package com.hyygybs.statscrystal.item;

import com.hyygybs.statscrystal.capability.PlayerStatsProvider;
import com.hyygybs.statscrystal.utils.AttributeUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class PowerCrystal extends Item {
    public PowerCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!world.isClientSide) {
            player.getCapability(PlayerStatsProvider.PLAYER_STATS).ifPresent(capability -> {
                capability.addExtraAttack(1);
                capability.addExtraArrowDamage(1);

                AttributeUtil.applyAttributes(player, false);

                stack.shrink(1);
                player.playNotifySound(SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1.0F, 1.0F);
            });
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        tooltip.add(Component.translatable("tooltip.statscrystal.power_crystal").withStyle(ChatFormatting.GRAY,ChatFormatting.ITALIC));
    }
}