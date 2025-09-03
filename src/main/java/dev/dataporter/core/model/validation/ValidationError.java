package dev.dataporter.core.model.validation;

import dev.dataporter.core.enums.ErrorSeverity;
import dev.dataporter.core.enums.ErrorType;


public class ValidationError {
    private String message;
    private ValidationErrorDetail errorDetail;
    private ErrorType errorType;
    private ErrorSeverity severity = ErrorSeverity.WARNING;

    public ValidationError(String message, ErrorType errorType, ErrorSeverity severity) {
        this.message = message;
        this.errorType = errorType;
        this.severity = severity;
    }
    public boolean isSevere() {
        return severity == ErrorSeverity.SEVERE;
    }
}
