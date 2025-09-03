package dev.dataporter.core.model.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private boolean shouldProcessHalted = false;
    private final List<ValidationError> errors = new ArrayList<>();

    public void addError(ValidationError error) {
        errors.add(error);
        if(error.isSevere()) {
            shouldProcessHalted = true;
        }
    }

    public boolean shouldProcessHalted() {
        return shouldProcessHalted;
    }
}
