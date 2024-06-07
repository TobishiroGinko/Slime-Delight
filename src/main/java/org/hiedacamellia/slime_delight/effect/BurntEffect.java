package org.hiedacamellia.slime_delight.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class BurntEffect extends StatusEffect {
    public BurntEffect() {
        super(StatusEffectCategory.HARMFUL, 0);
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getEntityWorld().isClient() && entity instanceof PlayerEntity player) {
            player.damage(player.getDamageSources().lava(), 4);
        }
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
