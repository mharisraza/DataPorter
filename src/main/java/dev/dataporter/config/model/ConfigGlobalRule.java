package dev.dataporter.config.model;

import dev.dataporter.config.policy.DuplicateRowPolicy;
import dev.dataporter.config.policy.ExtraColumnPolicy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Represents dataset-level validation and processing rules that apply
 * globally to an uploaded file.
 * <p>*/

@Getter
@Setter
@NoArgsConstructor
public class ConfigGlobalRule {
    private int minRowsCount;
    private int maxRowsCount;

    private boolean skipEmptyRows;
    private boolean headerCaseSensitive;
    private boolean multiSheetSupport;
    private boolean normalizeHeaders;

    private DuplicateRowPolicy duplicateRowPolicy;
    private ExtraColumnPolicy extraColumnPolicy;
}
