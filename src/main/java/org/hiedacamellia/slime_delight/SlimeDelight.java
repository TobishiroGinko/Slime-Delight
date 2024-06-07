package org.hiedacamellia.slime_delight;

import net.fabricmc.api.ModInitializer;
import org.hiedacamellia.slime_delight.registry.*;

public class SlimeDelight implements ModInitializer {
    public static final String MODID = "slime_delight";
    @Override
    public void onInitialize() {
        ItemGroupRegistry.register();
        BlockRegistry.register();
        ItemRegistry.register();
        EffectRegistry.register();
        EventRegistry.register();
    }
}
