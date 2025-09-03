package dev.dataporter;

import dev.dataporter.core.config.loader.ConfigLoader;
import dev.dataporter.core.config.model.Config;
import dev.dataporter.core.config.parser.ConfigParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Path;

@SpringBootTest
class DataPorterApplicationTests {

	@Test
	void loadAndParseConfiguration() throws IOException {
		String loadedRawConfiguration = new ConfigLoader(Path.of("/src/main/resources/static/test.json")).load();
		Config loadedConfiguration = new ConfigParser(loadedRawConfiguration).parse();
		assert loadedConfiguration != null && !loadedConfiguration.getHeaderConfigs().isEmpty();
	}
}
