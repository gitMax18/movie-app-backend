package com.maxime.movieappbackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.response.ErrorResponse;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleRessourceNotFoundException(RessourceNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(exception.getHttpStatusCode(), exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
}
