package com.example.mtbs.exception;

public class TheaterDoesNotExistException extends RuntimeException {

    private String message;

    public TheaterDoesNotExistException(String message) {
        this.message = message;
    }
}
