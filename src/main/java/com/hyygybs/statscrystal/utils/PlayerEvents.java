package com.hyygybs.statscrystal.utils;

import com.hyygybs.statscrystal.capability.PlayerStatsCapability;
import com.hyygybs.statscrystal.capability.PlayerStatsProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerEvents {
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            Player original = event.getOriginal();
            Player newPlayer = event.getEntity();

            original.reviveCaps();
            PlayerStatsCapability oldStats = original.getCapability(PlayerStatsProvider.PLAYER_STATS).orElseThrow(
                    () -> new IllegalStateException("PlayerStats capability not found on original player"));

            PlayerStatsCapability newStats = newPlayer.getCapability(PlayerStatsProvider.PLAYER_STATS).orElseThrow(
                    () -> new IllegalStateException("PlayerStats capability not found on new player"));

            newStats.deserializeNBT(oldStats.serializeNBT());
            original.invalidateCaps();

            AttributeUtil.applyAttributes(newPlayer, true);
        }
        else {
            Player original = event.getOriginal();
            Player newPlayer = event.getEntity();

            original.reviveCaps();
            PlayerStatsCapability oldStats = original.getCapability(PlayerStatsProvider.PLAYER_STATS).orElseThrow(
                    () -> new IllegalStateException("PlayerStats capability not found on original player"));

            PlayerStatsCapability newStats = newPlayer.getCapability(PlayerStatsProvider.PLAYER_STATS).orElseThrow(
                    () -> new IllegalStateException("PlayerStats capability not found on new player"));

            newStats.deserializeNBT(oldStats.serializeNBT());
            original.invalidateCaps();

            AttributeUtil.applyAttributes(newPlayer, false);
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        player.getServer().execute(() -> {
            AttributeUtil.applyAttributes(player, true);
        });
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        AttributeUtil.applyAttributes(player);
    }

    @SubscribeEvent
    public static void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        AttributeUtil.applyAttributes(player);
    }
}
