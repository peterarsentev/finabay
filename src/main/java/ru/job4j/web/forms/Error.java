package ru.job4j.web.forms;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
public class Error extends Result {
    private final String error;

    public Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
