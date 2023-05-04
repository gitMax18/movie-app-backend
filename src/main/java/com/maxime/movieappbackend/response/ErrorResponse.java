package com.maxime.movieappbackend.response;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private int statusCode;
    private String message;
    private Long timestamp;
    private Map<String, String> details = new HashMap<>();

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, String message, Map<String, String> details) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.details = details;
    }

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getDetails() {
        return this.details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

}
