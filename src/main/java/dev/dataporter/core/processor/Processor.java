package dev.dataporter.core.processor;

public interface Processor<T, K> {
    public T process(T target, K source);
}
