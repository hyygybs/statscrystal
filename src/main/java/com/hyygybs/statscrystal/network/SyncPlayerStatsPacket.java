package com.hyygybs.statscrystal.network;

import com.hyygybs.statscrystal.capability.PlayerStatsCapability;
import com.hyygybs.statscrystal.capability.PlayerStatsProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncPlayerStatsPacket {
    private final int extraHearts;
    private final int extraAttack;
    private final int extraArmor;
    private final int extraArmorToughness;
    private final int extraAttackSpeed;
    private final int extraArrowDamage;
    private final int extraDrawSpeed;
    private final int extraKnockbackResist;
    private final int extraDodgeChance;
    private final int extraHealing;
    private final int extraLuck;
    private final int extraExpGained;
    private final int extraLifeSteal;
    private final int extraOverHeal;

    public SyncPlayerStatsPacket(PlayerStatsCapability capability) {
        this.extraHearts = capability.getExtraHearts();
        this.extraAttack = capability.getExtraAttack();
        this.extraArmor = capability.getExtraArmor();
        this.extraArmorToughness = capability.getExtraArmorToughness();
        this.extraAttackSpeed = capability.getExtraAttackSpeed();
        this.extraArrowDamage = capability.getExtraArrowDamage();
        this.extraDrawSpeed = capability.getExtraDrawSpeed();
        this.extraKnockbackResist = capability.getExtraKnockbackResist();
        this.extraDodgeChance = capability.getExtraDodgeChance();
        this.extraHealing = capability.getExtraHealing();
        this.extraLuck = capability.getExtraLuck();
        this.extraExpGained = capability.getExtraExpGained();
        this.extraLifeSteal = capability.getExtraLifeSteal();
        this.extraOverHeal = capability.getExtraOverHeal();
    }

    public SyncPlayerStatsPacket(FriendlyByteBuf buf) {
        this.extraHearts = buf.readInt();
        this.extraAttack = buf.readInt();
        this.extraArmor = buf.readInt();
        this.extraArmorToughness = buf.readInt();
        this.extraAttackSpeed = buf.readInt();
        this.extraArrowDamage = buf.readInt();
        this.extraDrawSpeed = buf.readInt();
        this.extraKnockbackResist = buf.readInt();
        this.extraDodgeChance = buf.readInt();
        this.extraHealing = buf.readInt();
        this.extraLuck = buf.readInt();
        this.extraExpGained = buf.readInt();
        this.extraLifeSteal = buf.readInt();
        this.extraOverHeal = buf.readInt();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(extraHearts);
        buf.writeInt(extraAttack);
        buf.writeInt(extraArmor);
        buf.writeInt(extraArmorToughness);
        buf.writeInt(extraAttackSpeed);
        buf.writeInt(extraArrowDamage);
        buf.writeInt(extraDrawSpeed);
        buf.writeInt(extraKnockbackResist);
        buf.writeInt(extraDodgeChance);
        buf.writeInt(extraHealing);
        buf.writeInt(extraLuck);
        buf.writeInt(extraExpGained);
        buf.writeInt(extraLifeSteal);
        buf.writeInt(extraOverHeal);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                player.getCapability(PlayerStatsProvider.PLAYER_STATS).ifPresent(cap -> {
                    cap.setExtraHearts(extraHearts);
                    cap.setExtraAttack(extraAttack);
                    cap.setExtraArmor(extraArmor);
                    cap.setExtraArmorToughness(extraArmorToughness);
                    cap.setExtraAttackSpeed(extraAttackSpeed);
                    cap.setExtraArrowDamage(extraArrowDamage);
                    cap.setExtraDrawSpeed(extraDrawSpeed);
                    cap.setExtraKnockbackResist(extraKnockbackResist);
                    cap.setExtraDodgeChance(extraDodgeChance);
                    cap.setExtraHealing(extraHealing);
                    cap.setExtraLuck(extraLuck);
                    cap.setExtraExpGained(extraExpGained);
                    cap.setExtraLifeSteal(extraLifeSteal);
                    cap.setExtraOverHeal(extraOverHeal);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
