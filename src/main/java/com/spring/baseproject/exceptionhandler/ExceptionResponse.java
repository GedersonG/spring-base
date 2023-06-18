package com.spring.baseproject.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data associated with the request was found.");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}