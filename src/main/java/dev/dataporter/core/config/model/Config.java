package dev.dataporter.core.config.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Config {
    private String configName;
    private ConfigGlobalRule configGlobalRule;
    private List<HeaderConfig> headerConfigs;

    private Date configCreationDate;
    private Date configModifiedDate;
}
