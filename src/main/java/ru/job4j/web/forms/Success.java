package ru.job4j.web.forms;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
public class Success<T> extends Result {
    private final T value;

    public Success(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
