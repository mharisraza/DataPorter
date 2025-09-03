package dev.dataporter.core.config.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the configuration for a single header (column) in a dataset.
 * <p>
 * A {@code HeaderConfig} defines the rules and constraints that apply
 * to a specific column in an uploaded file.
 * */

@Getter
@Setter
@NoArgsConstructor
public class HeaderConfig {

    private String name;
    private String validation;
    private String validationMessage;
    private String defaultValue;
    private String[] whitelist;
    private String[] blacklist;

    private int minLength = 1;
    private int maxLength = 32_767; // white space include if allowed;

    private boolean isRequired = false;
    private boolean isUnique = false;

}
