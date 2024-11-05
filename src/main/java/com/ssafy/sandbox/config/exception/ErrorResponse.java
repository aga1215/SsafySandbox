package com.ssafy.sandbox.config.exception;

public class ErrorResponse {
    private final String message;
    private final int statusCode;
    private final String details;

    public ErrorResponse(String message, int statusCode, String details) {
        this.message = message;
        this.statusCode = statusCode;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDetails() {
        return details;
    }
}
