package dev.dataporter.core.model.validation;


import jdk.jfr.StackTrace;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationErrorDetail {
    private int errorLocation;
    private String[] errorMessages;
}
