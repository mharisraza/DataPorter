package dev.dataporter.core.config.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Loads a configuration file from the configured-file system and returns
 * its contents as a raw JSON string.
 */
public class ConfigLoader {
    private final Path configFile;

    public ConfigLoader(Path configFile) {
        this.configFile = configFile;
    }

    public String load() throws IOException {
        return Files.readString(configFile);
    }
}
