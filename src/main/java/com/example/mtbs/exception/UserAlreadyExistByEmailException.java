package com.example.mtbs.exception;

public class UserAlreadyExistByEmailException extends RuntimeException {

    private String message;

    public UserAlreadyExistByEmailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
