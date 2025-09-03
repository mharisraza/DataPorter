package dev.dataporter.core.validator;


public interface Validator<T> {
    void validate(T target);
}
