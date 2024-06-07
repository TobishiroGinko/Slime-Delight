package org.hiedacamellia.slime_delight.registry;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import org.hiedacamellia.slime_delight.event.LavaLargeBowlEvent;

public class EventRegistry {
    public static void register() {
        UseBlockCallback.EVENT.register(LavaLargeBowlEvent::onUseBlock);
    }
}
