package io.github.racoondog.meteornorbit;

import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class MeteorNorbit extends MeteorAddon {
    private static final Path CONFIG_FILE = FabricLoader.getInstance().getGameDir().resolve("meteor-client").resolve("meteor-norbit.txt");
    private static final Logger LOG = LogUtils.getLogger();
    @Override
    public void onInitialize() {}

    @Override
    public String getPackage() {
        return "io.github.racoondog.meteornorbit";
    }

    public static boolean safeThread(){
        if (!Files.isRegularFile(CONFIG_FILE)) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(CONFIG_FILE, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                bufferedWriter.write("//true = safe thread, false = unsafe thread \n");
                bufferedWriter.write("threadSafe:true");
            } catch (IOException e) {
                LOG.error("Failed to create Safety Config");
                e.printStackTrace();
            }
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(CONFIG_FILE)) {
            bufferedReader.readLine();
            String line = Objects.requireNonNullElse(bufferedReader.readLine(), "ERROR");
            if (line.equals("ERROR")) throw new IOException("Second line is not the config"); else return Boolean.parseBoolean(line.substring(11));
        } catch (IOException e) {
            LOG.error("Failed to load Safety Config");
            e.printStackTrace();
        }
        return true;
    }
}
