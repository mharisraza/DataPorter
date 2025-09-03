package dev.dataporter.core.config.model;

import dev.dataporter.core.config.policy.DuplicateRowPolicy;
import dev.dataporter.core.config.policy.ExtraColumnPolicy;
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
    private int minRowsCount = 1; // 0-indexed headers + row (so 2 rows)
    private int maxRowsCount = 1_048_576; // excel max rows capability

    private boolean skipEmptyRows = true;
    private boolean headerCaseSensitive = true;
    private boolean multiSheetSupport = false;
    private boolean normalizeHeaders = true;

    private DuplicateRowPolicy duplicateRowPolicy = DuplicateRowPolicy.ALLOW;
    private ExtraColumnPolicy extraColumnPolicy = ExtraColumnPolicy.IGNORE;
}
