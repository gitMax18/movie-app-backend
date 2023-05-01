package com.maxime.movieappbackend.Exception.exceptionTypes;

import org.springframework.http.HttpStatus;

public class RessourceNotFoundException extends RuntimeException {
    private final int httpStatusCode = HttpStatus.NOT_FOUND.value();

    public RessourceNotFoundException() {
        super();
    }

    public RessourceNotFoundException(String message) {
        super(message);
    }

    public RessourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RessourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
