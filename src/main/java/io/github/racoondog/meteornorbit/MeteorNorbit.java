package io.github.racoondog.meteornorbit;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MeteorNorbit extends MeteorAddon {
    @Override
    public void onInitialize() {}

    @Override
    public String getPackage() {
        return "io.github.racoondog.meteornorbit";
    }
}
