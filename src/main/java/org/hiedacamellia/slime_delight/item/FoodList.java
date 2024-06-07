package org.hiedacamellia.slime_delight.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class FoodList {
    public static final FoodComponent GrassBlockCakeSlice = new FoodComponent.Builder().hunger(3).saturationModifier(0.33f).build();
    public static final FoodComponent BowlOfNetherStew = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*180,0),1).build();
    public static final FoodComponent BurntFish = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
    public static final FoodComponent BurntPotato = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
    public static final FoodComponent GoldenSlimeBall = new FoodComponent.Builder().hunger(6).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,20*30,0),1).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,20*30,1),1).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*30,1),1).build();
    public static final FoodComponent SlimePocky = new FoodComponent.Builder().hunger(2).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*3,1),1).alwaysEdible().build();
    public static final FoodComponent SlimeRice = new FoodComponent.Builder().hunger(6).saturationModifier(0.75f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*60,1),1).build();
    public static final FoodComponent MagmaCreamRice = new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*60,0),1).build();
    public static final FoodComponent BowlOfGoo = new FoodComponent.Builder().hunger(5).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*50,1),1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,20*20,1),1).build();
    public static final FoodComponent SlimePudding = new FoodComponent.Builder().hunger(4).saturationModifier(0.75f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20*30,0),1).alwaysEdible().build();
    public static final FoodComponent MagmaCreamPudding = new FoodComponent.Builder().hunger(4).saturationModifier(0.75f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*30,0),1).alwaysEdible().build();
    public static final FoodComponent GelatinCandy = new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).alwaysEdible().build();
}
