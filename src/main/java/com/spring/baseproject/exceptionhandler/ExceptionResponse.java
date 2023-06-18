package com.spring.baseproject.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data associated with the request was found."),
    ALREADY_EXISTS("Ya existe un recurso con esos datos"),
    BAD_VALUE("El valor insertado es incorrecto");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}