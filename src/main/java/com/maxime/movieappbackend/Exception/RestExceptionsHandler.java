package com.maxime.movieappbackend.Exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.Exception.exceptionTypes.UniqueConstraintException;
import com.maxime.movieappbackend.dto.response.ErrorResponse;

import org.springframework.validation.FieldError;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleRessourceNotFoundException(RessourceNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(exception.getHttpStatusCode(), exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUniqueConstaintException(UniqueConstraintException exception) {
        ErrorResponse error = new ErrorResponse(exception.getHttpStatusCode(), exception.getMessage(),
                exception.getDetails());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    // @ExceptionHandler(DataIntegrityViolationException.class)
    // public ResponseEntity<ErrorResponse>
    // handleIntegrityException(DataIntegrityViolationException exception) {
    // // if (exception.getCause() instanceof ConstraintViolationException) {
    // ConstraintViolationException cve = (ConstraintViolationException)
    // exception.getCause();
    // Map<String, String> details = new HashMap<>();
    // details.put(cve.getConstraintName(), cve.getConstraintName() + " must be
    // unique");
    // ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
    // "Unique constraint error", details);
    // return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    // // } else {
    // // throw (exception);
    // }

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Constraint Error", errors);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

}
