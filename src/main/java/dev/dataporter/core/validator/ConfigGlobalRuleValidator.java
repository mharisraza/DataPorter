package dev.dataporter.core.validator;

import dev.dataporter.core.config.model.ConfigGlobalRule;
import dev.dataporter.core.enums.ErrorSeverity;
import dev.dataporter.core.enums.ErrorType;
import dev.dataporter.core.model.data.DataSheet;
import dev.dataporter.core.model.validation.ValidationError;
import dev.dataporter.core.model.validation.ValidationResult;


public class ConfigGlobalRuleValidator implements Validator<DataSheet>{

    private final ConfigGlobalRule configGlobalRule;
    private final ValidationResult validationResult;

    public ConfigGlobalRuleValidator(ConfigGlobalRule configGlobalRule, ValidationResult validationFailedResult) {
        this.configGlobalRule = configGlobalRule;
        this.validationResult = validationFailedResult;
    }
    @Override
    public void validate(DataSheet dataSet) {
        validateMinRowsCount(dataSet);
        validateMaxRowsCount(dataSet);
    }

    private void validateMinRowsCount(DataSheet dataSheet) {
        if(dataSheet.getDataRows().size() < configGlobalRule.getMinRowsCount()) {
            validationResult.addError(new ValidationError(String.format("Minimum Required rows are %d", configGlobalRule.getMinRowsCount()), ErrorType.DATA_SHEET, ErrorSeverity.SEVERE));
        }
    }

    private void validateMaxRowsCount(DataSheet dataSheet) {
        if(dataSheet.getDataRows().size() > configGlobalRule.getMaxRowsCount()) {
            validationResult.addError(new ValidationError(String.format("Rows cannot be exceed more than %d", configGlobalRule.getMaxRowsCount()), ErrorType.DATA_SHEET, ErrorSeverity.SEVERE));
        }
    }


}
