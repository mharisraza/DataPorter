package dev.dataporter.core.config.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dataporter.core.config.model.Config;

public class ConfigParser {
    private final String config;

    public ConfigParser(String config) {
        this.config = config;
    }

    public Config parse() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // disabling it may fail silently to map a value.
        return mapper.readValue(config, Config.class);
    }


}
