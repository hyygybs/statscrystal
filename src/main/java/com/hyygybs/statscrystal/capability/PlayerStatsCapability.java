package com.hyygybs.statscrystal.capability;

import com.hyygybs.statscrystal.network.NetworkHandler;
import com.hyygybs.statscrystal.network.SyncPlayerStatsPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class PlayerStatsCapability {
    private int extraHearts;
    private int extraAttack;
    private int extraArmor;
    private int extraArmorToughness;
    private int extraAttackSpeed;
    private int extraArrowDamage;
    private int extraDrawSpeed;
    private int extraKnockbackResist;
    private int extraDodgeChance;
    private int extraHealing;
    private int extraLuck;
    private int extraExpGained;
    private int extraLifeSteal;
    private int extraOverHeal;

    public void addExtraHearts(int amount) {
        this.extraHearts += amount;
    }
    public void addExtraAttack(int amount) {this.extraAttack += amount;}
    public void addExtraArmor(int amount) {
        this.extraArmor += amount;
    }
    public void addExtraArmorToughness(int amount) {
        this.extraArmorToughness += amount;
    }
    public void addExtraAttackSpeed(int amount) {
        this.extraAttackSpeed += amount;
    }
    public void addExtraArrowDamage(int amount) {
        this.extraArrowDamage += amount;
    }
    public void addExtraDrawSpeed(int amount) {
        this.extraDrawSpeed += amount;
    }
    public void addExtraKnockbackResist(int amount) {
        this.extraKnockbackResist += amount;
    }
    public void addExtraDodgeChance(int amount) {
        this.extraDodgeChance += amount;
    }
    public void addExtraHealing(int amount) {
        this.extraHealing += amount;
    }
    public void addExtraLuck(int amount) {
        this.extraLuck += amount;
    }
    public void addExtraExpGained(int amount) {
        this.extraExpGained += amount;
    }
    public void addExtraLifeSteal(int amount) {
        this.extraLifeSteal += amount;
    }
    public void addExtraOverHeal(int amount) {
        this.extraOverHeal += amount;
    }

    public int getExtraHearts() {
        return extraHearts;
    }
    public int getExtraAttack() {
        return extraAttack;
    }
    public int getExtraArmor() {
        return extraArmor;
    }
    public int getExtraArmorToughness() {
        return extraArmorToughness;
    }
    public int getExtraAttackSpeed() {return extraAttackSpeed;}
    public int getExtraArrowDamage() {return extraArrowDamage;}
    public int getExtraDrawSpeed() {return extraDrawSpeed;}
    public int getExtraKnockbackResist() {return extraKnockbackResist;}
    public int getExtraDodgeChance() {return extraDodgeChance;}
    public int getExtraHealing() {return extraHealing;}
    public int getExtraLuck() {return extraLuck;}
    public int getExtraExpGained() {return extraExpGained;}
    public int getExtraLifeSteal() {return extraLifeSteal;}
    public int getExtraOverHeal() {return extraOverHeal;}

    public void setExtraHearts(int extraHearts) {
        this.extraHearts = extraHearts;
    }
    public void setExtraAttack(int extraAttack) {
        this.extraAttack = extraAttack;
    }
    public void setExtraArmor(int extraArmor) {
        this.extraArmor = extraArmor;
    }
    public void setExtraArmorToughness(int extraArmorToughness) {
        this.extraArmorToughness = extraArmorToughness;
    }
    public void setExtraAttackSpeed(int extraAttackSpeed) {
        this.extraAttackSpeed = extraAttackSpeed;
    }
    public void setExtraArrowDamage(int extraArrowDamage) {
        this.extraArrowDamage = extraArrowDamage;
    }
    public void setExtraDrawSpeed(int extraDrawSpeed) {
        this.extraDrawSpeed = extraDrawSpeed;
    }
    public void setExtraKnockbackResist(int extraKnockbackResist) {
        this.extraKnockbackResist = extraKnockbackResist;
    }
    public void setExtraDodgeChance(int extraDodgeChance) {
        this.extraDodgeChance = extraDodgeChance;
    }
    public void setExtraHealing(int extraHealing) {
        this.extraHealing = extraHealing;
    }
    public void setExtraLuck(int extraLuck) {
        this.extraLuck = extraLuck;
    }
    public void setExtraExpGained(int extraExpGained) {
        this.extraExpGained = extraExpGained;
    }
    public void setExtraLifeSteal(int extraLifeSteal) {
        this.extraLifeSteal = extraLifeSteal;
    }
    public void setExtraOverHeal(int extraOverHeal) {
        this.extraOverHeal = extraOverHeal;
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("extraHearts", extraHearts);
        tag.putInt("extraAttack", extraAttack);
        tag.putInt("extraArmor", extraArmor);
        tag.putInt("extraArmorToughness", extraArmorToughness);
        tag.putInt("extraAttackSpeed", extraAttackSpeed);
        tag.putInt("extraArrowDamage", extraArrowDamage);
        tag.putInt("extraDrawSpeed", extraDrawSpeed);
        tag.putInt("extraKnockbackResist", extraKnockbackResist);
        tag.putInt("extraDodgeChance", extraDodgeChance);
        tag.putInt("extraHealing", extraHealing);
        tag.putInt("extraLuck", extraLuck);
        tag.putInt("extraExpGained", extraExpGained);
        tag.putInt("extraLifeSteal", extraLifeSteal);
        tag.putInt("extraOverHeal", extraOverHeal);
        return tag;
    }

    public void deserializeNBT(CompoundTag tag) {
        extraHearts = tag.getInt("extraHearts");
        extraAttack = tag.getInt("extraAttack");
        extraArmor = tag.getInt("extraArmor");
        extraArmorToughness = tag.getInt("extraArmorToughness");
        extraAttackSpeed = tag.getInt("extraAttackSpeed");
        extraArrowDamage = tag.getInt("extraArrowDamage");
        extraDrawSpeed = tag.getInt("extraDrawSpeed");
        extraKnockbackResist = tag.getInt("extraKnockbackResist");
        extraDodgeChance = tag.getInt("extraDodgeChance");
        extraHealing = tag.getInt("extraHealing");
        extraLuck = tag.getInt("extraLuck");
        extraExpGained = tag.getInt("extraExpGained");
        extraLifeSteal = tag.getInt("extraLifeSteal");
        extraOverHeal = tag.getInt("extraOverHeal");
    }

    public void syncToPlayer(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            SyncPlayerStatsPacket packet = new SyncPlayerStatsPacket(this);
            NetworkHandler.sendToClient(packet, serverPlayer);
        }
    }
}
