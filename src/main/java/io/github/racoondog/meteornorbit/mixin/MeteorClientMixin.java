package io.github.racoondog.meteornorbit.mixin;

import io.github.racoondog.norbit.EventBus;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Environment(EnvType.CLIENT)
@Mixin(value = MeteorClient.class, remap = false)
public abstract class MeteorClientMixin {
    @SuppressWarnings({"ShadowModifiers", "unused"})
    @Shadow public static final IEventBus EVENT_BUS = EventBus.threadSafe();
}
