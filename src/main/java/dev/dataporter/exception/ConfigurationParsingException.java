package dev.dataporter.exception;

public class ConfigurationParsingException extends RuntimeException {
    public ConfigurationParsingException() {
        super("Failed to parse configuration file");
    }
}
