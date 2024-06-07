package org.hiedacamellia.slime_delight.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.hiedacamellia.slime_delight.SlimeDelight;
import org.hiedacamellia.slime_delight.effect.BurntEffect;

public enum EffectRegistry {
    Burnt("burnt", new BurntEffect()),;

    private final String pathName;
    private final StatusEffect effect;

    private EffectRegistry(String pathName, StatusEffect effect) {
        this.pathName = pathName;
        this.effect = effect;
    }

    public static void register() {
        for (EffectRegistry value : values()) {
            Registry.register(Registries.STATUS_EFFECT, new Identifier(SlimeDelight.MODID, value.pathName), value.get());
        }
    }

    public StatusEffect get() {
        return this.effect;
    }
}
