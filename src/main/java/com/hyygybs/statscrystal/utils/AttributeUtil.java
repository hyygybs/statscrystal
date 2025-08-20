package com.hyygybs.statscrystal.utils;

import com.hyygybs.statscrystal.capability.PlayerStatsCapability;
import com.hyygybs.statscrystal.capability.PlayerStatsProvider;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

public class AttributeUtil {
    private static final UUID MAX_HEALTH_MODIFIER_ID = UUID.fromString("d8a6e8e7-1e10-4f7a-9f0a-9d9c1d9e0f1a");
    private static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("b3a3e3e7-1e10-4f7a-9f0a-9d9c1d9e0f1b");
    private static final UUID ARMOR_MODIFIER_ID = UUID.fromString("c4a4e4e7-1e10-4f7a-9f0a-9d9c1d9e0f1c");
    private static final UUID ARMOR_TOUGHNESS_MODIFIER_ID = UUID.fromString("d5a5e5e7-1e10-4f7a-9f0a-9d9c1d9e0f1d");
    private static final UUID ATTACK_SPEED_MODIFIER_ID = UUID.fromString("e6a6e6e7-1e10-4f7a-9f0a-9d9c1d9e0f1e");
    private static final UUID ARROW_DAMAGE_MODIFIER_ID = UUID.fromString("c950de44-152e-4b92-9338-9a59b1af9639");
    private static final UUID DRAW_SPEED_MODIFIER_ID = UUID.fromString("957ceb7e-ef14-4a10-bc2a-e63c8cd50c39");
    private static final UUID KNOCKBACK_RESISTANCE_MODIFIER_ID = UUID.fromString("62ffee9f-c4c2-4ffe-81b9-b0982e547d26");
    private static final UUID DODGE_CHANCE_MODIFIER_ID = UUID.fromString("de70d15c-8f2a-474b-9680-2760058f47ff");
    private static final UUID HEALING_RECEIVED_MODIFIER_ID = UUID.fromString("8b620210-4112-43ae-b0aa-3d7191409197");
    private static final UUID LUCK_MODIFIER_ID = UUID.fromString("9648921f-0e95-46b3-8bb5-48efea02f0ef");
    private static final UUID EXPERIENCE_GAINED_MODIFIER_ID = UUID.fromString("cbaac356-0750-499a-88ff-8ddc7f3797f9");
    private static final UUID LIFE_STEAL_MODIFIER_ID = UUID.fromString("bd0b656e-a5e9-4bd9-8bdd-c043f0fc7aed");
    private static final UUID OVERHEAL_MODIFIER_ID = UUID.fromString("7e128af5-c356-4268-89ed-539bb78e4b39");

    public static void applyAttributes(Player player, boolean fullHealAfterUpdate) {
        if (!(player instanceof ServerPlayer)) return;

        PlayerStatsCapability stats = player.getCapability(PlayerStatsProvider.PLAYER_STATS).orElse(null);
        if (stats == null) return;

        updateHealthAttribute(player, stats);
        updateAttackDamageAttribute(player, stats);
        updateArmorAttribute(player, stats);
        updateArmorToughnessAttribute(player, stats);
        updateAttackSpeedAttribute(player, stats);
        updateArrowDamageAttribute(player, stats);
        updateDrawSpeedAttribute(player, stats);
        updateKnockbackResistAttribute(player, stats);
        updateDodgeChanceAttribute(player, stats);
        updateHealingAttribute(player, stats);
        updateLuckAttribute(player, stats);
        updateExpGainedAttribute(player, stats);
        updateLifeStealAttribute(player, stats);
        updateOverHealAttribute(player, stats);

        postAttributeUpdate(player, stats, fullHealAfterUpdate);
    }

    public static void applyAttributes(Player player) {
        applyAttributes(player, false);
    }

    private static void updateHealthAttribute(Player player, PlayerStatsCapability stats) {
        double maxHealthBonus = stats.getExtraHearts() * 2;
        AttributeInstance maxHealthAttr = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            maxHealthAttr.removeModifier(MAX_HEALTH_MODIFIER_ID);
            maxHealthAttr.addPermanentModifier(new AttributeModifier(
                    MAX_HEALTH_MODIFIER_ID,
                    "stats_crystal.extra_hearts",
                    maxHealthBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateAttackDamageAttribute(Player player, PlayerStatsCapability stats) {
        double attackDamageBonus = stats.getExtraAttack();
        AttributeInstance attackDamageAttr = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackDamageAttr != null) {
            attackDamageAttr.removeModifier(ATTACK_DAMAGE_MODIFIER_ID);
            attackDamageAttr.addPermanentModifier(new AttributeModifier(
                    ATTACK_DAMAGE_MODIFIER_ID,
                    "stats_crystal.extra_attack",
                    attackDamageBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateArmorAttribute(Player player, PlayerStatsCapability stats) {
        double armorBonus = stats.getExtraArmor();
        AttributeInstance armorAttr = player.getAttribute(Attributes.ARMOR);
        if (armorAttr != null) {
            armorAttr.removeModifier(ARMOR_MODIFIER_ID);
            armorAttr.addPermanentModifier(new AttributeModifier(
                    ARMOR_MODIFIER_ID,
                    "stats_crystal.extra_armor",
                    armorBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateArmorToughnessAttribute(Player player, PlayerStatsCapability stats) {
        double armorToughnessBonus = stats.getExtraArmorToughness();
        AttributeInstance armorToughnessAttr = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughnessAttr != null) {
            armorToughnessAttr.removeModifier(ARMOR_TOUGHNESS_MODIFIER_ID);
            armorToughnessAttr.addPermanentModifier(new AttributeModifier(
                    ARMOR_TOUGHNESS_MODIFIER_ID,
                    "stats_crystal.extra_armor_toughness",
                    armorToughnessBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateAttackSpeedAttribute(Player player, PlayerStatsCapability stats) {
        double attackSpeedBonus = stats.getExtraAttackSpeed() * 0.1;
        AttributeInstance attackSpeedAttr = player.getAttribute(Attributes.ATTACK_SPEED);
        if (attackSpeedAttr != null) {
            attackSpeedAttr.removeModifier(ATTACK_SPEED_MODIFIER_ID);
            attackSpeedAttr.addPermanentModifier(new AttributeModifier(
                    ATTACK_SPEED_MODIFIER_ID,
                    "stats_crystal.extra_attack_speed",
                    attackSpeedBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateArrowDamageAttribute(Player player, PlayerStatsCapability stats) {
        double arrowDamageBonus = stats.getExtraArrowDamage();
        AttributeInstance arrowDamageAttr = player.getAttribute(ALObjects.Attributes.ARROW_DAMAGE.get());
        if (arrowDamageAttr != null) {
            arrowDamageAttr.removeModifier(ARROW_DAMAGE_MODIFIER_ID);
            arrowDamageAttr.addPermanentModifier(new AttributeModifier(
                    ARROW_DAMAGE_MODIFIER_ID,
                    "stats_crystal.extra_arrow_damage",
                    arrowDamageBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateDrawSpeedAttribute(Player player, PlayerStatsCapability stats) {
        double drawSpeedBonus = stats.getExtraDrawSpeed() * 0.1;
        AttributeInstance drawSpeedAttr = player.getAttribute(ALObjects.Attributes.DRAW_SPEED.get());
        if (drawSpeedAttr != null) {
            drawSpeedAttr.removeModifier(DRAW_SPEED_MODIFIER_ID);
            drawSpeedAttr.addPermanentModifier(new AttributeModifier(
                    DRAW_SPEED_MODIFIER_ID,
                    "stats_crystal.extra_draw_speed",
                    drawSpeedBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateKnockbackResistAttribute(Player player, PlayerStatsCapability stats) {
        double knockbackResistBonus = stats.getExtraKnockbackResist() * 0.1;
        AttributeInstance knockbackResistAttr = player.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        if (knockbackResistAttr != null) {
            knockbackResistAttr.removeModifier(KNOCKBACK_RESISTANCE_MODIFIER_ID);
            knockbackResistAttr.addPermanentModifier(new AttributeModifier(
                    KNOCKBACK_RESISTANCE_MODIFIER_ID,
                    "stats_crystal.extra_knockback_resistance",
                    knockbackResistBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateDodgeChanceAttribute(Player player, PlayerStatsCapability stats) {
        double dodgeChanceBonus = stats.getExtraDodgeChance() * 0.01;
        AttributeInstance dodgeChanceAttr = player.getAttribute(ALObjects.Attributes.DODGE_CHANCE.get());
        if (dodgeChanceAttr != null) {
            dodgeChanceAttr.removeModifier(DODGE_CHANCE_MODIFIER_ID);
            dodgeChanceAttr.addPermanentModifier(new AttributeModifier(
                    DODGE_CHANCE_MODIFIER_ID,
                    "stats_crystal.extra_dodge_chance",
                    dodgeChanceBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateHealingAttribute(Player player, PlayerStatsCapability stats) {
        double healingBonus = stats.getExtraHealing() * 0.1;
        AttributeInstance healingAttr = player.getAttribute(ALObjects.Attributes.HEALING_RECEIVED.get());
        if (healingAttr != null) {
            healingAttr.removeModifier(HEALING_RECEIVED_MODIFIER_ID);
            healingAttr.addPermanentModifier(new AttributeModifier(
                    HEALING_RECEIVED_MODIFIER_ID,
                    "stats_crystal.extra_healing_received",
                    healingBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateLuckAttribute(Player player, PlayerStatsCapability stats) {
        double luckBonus = stats.getExtraLuck();
        AttributeInstance luckAttr = player.getAttribute(Attributes.LUCK);
        if (luckAttr != null) {
            luckAttr.removeModifier(LUCK_MODIFIER_ID);
            luckAttr.addPermanentModifier(new AttributeModifier(
                    LUCK_MODIFIER_ID,
                    "stats_crystal.extra_luck",
                    luckBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateExpGainedAttribute(Player player, PlayerStatsCapability stats) {
        double expGainedBonus = stats.getExtraExpGained() * 0.1;
        AttributeInstance expGainedAttr = player.getAttribute(ALObjects.Attributes.EXPERIENCE_GAINED.get());
        if (expGainedAttr != null) {
            expGainedAttr.removeModifier(EXPERIENCE_GAINED_MODIFIER_ID);
            expGainedAttr.addPermanentModifier(new AttributeModifier(
                    EXPERIENCE_GAINED_MODIFIER_ID,
                    "stats_crystal.extra_experience_gained",
                    expGainedBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateLifeStealAttribute(Player player, PlayerStatsCapability stats) {
        double lifeStealBonus = stats.getExtraLifeSteal() * 0.1;
        AttributeInstance lifeStealAttr = player.getAttribute(ALObjects.Attributes.LIFE_STEAL.get());
        if (lifeStealAttr != null) {
            lifeStealAttr.removeModifier(LIFE_STEAL_MODIFIER_ID);
            lifeStealAttr.addPermanentModifier(new AttributeModifier(
                    LIFE_STEAL_MODIFIER_ID,
                    "stats_crystal.extra_life_steal",
                    lifeStealBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void updateOverHealAttribute(Player player, PlayerStatsCapability stats) {
        double overHealBonus = stats.getExtraOverHeal() * 0.1;
        AttributeInstance overHealAttr = player.getAttribute(ALObjects.Attributes.OVERHEAL.get());
        if (overHealAttr != null) {
            overHealAttr.removeModifier(OVERHEAL_MODIFIER_ID);
            overHealAttr.addPermanentModifier(new AttributeModifier(
                    OVERHEAL_MODIFIER_ID,
                    "stats_crystal.extra_overheal",
                    overHealBonus,
                    AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private static void postAttributeUpdate(Player player, PlayerStatsCapability stats, boolean fullHealAfterUpdate) {
        double maxHealth = player.getAttributeValue(Attributes.MAX_HEALTH);

        if (player.getHealth() > maxHealth) {
            player.setHealth((float) maxHealth);
        }

        if (fullHealAfterUpdate) {
            player.setHealth((float) maxHealth);
        }

        if (player instanceof ServerPlayer serverPlayer) {
            stats.syncToPlayer(serverPlayer);
        }
    }
}
