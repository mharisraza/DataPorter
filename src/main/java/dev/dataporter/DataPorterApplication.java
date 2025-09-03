package dev.dataporter;

import dev.dataporter.core.config.loader.ConfigLoader;
import dev.dataporter.core.config.model.Config;
import dev.dataporter.core.config.parser.ConfigParser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;

@SpringBootApplication
public class DataPorterApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DataPorterApplication.class, args);
	}

}
