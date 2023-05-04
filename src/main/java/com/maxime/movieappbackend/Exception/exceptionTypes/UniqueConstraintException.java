package com.maxime.movieappbackend.Exception.exceptionTypes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class UniqueConstraintException extends RuntimeException {
    private final int httpStatusCode = HttpStatus.BAD_REQUEST.value();
    private Map<String, String> details = new HashMap<>();

    public UniqueConstraintException() {
        super();
    }

    public UniqueConstraintException(String message, Map<String, String> details) {
        super(message);
        this.details = details;
    }

    public UniqueConstraintException(String message, Throwable cause, Map<String, String> details) {
        super(message, cause);
        this.details = details;

    }

    public UniqueConstraintException(Throwable cause, Map<String, String> details) {
        super(cause);
        this.details = details;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public Map<String, String> getDetails() {
        return this.details;
    }
}
