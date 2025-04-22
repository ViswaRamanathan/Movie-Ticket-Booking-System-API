package com.example.mtbs.exception;

public class UserDoesNotExistByEmailException extends RuntimeException {

    private String message;

    public UserDoesNotExistByEmailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
