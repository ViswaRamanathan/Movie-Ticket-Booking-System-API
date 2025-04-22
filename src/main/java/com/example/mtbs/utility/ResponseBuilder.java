package com.example.mtbs.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseStructure<T>> successResponse(T data, String message, HttpStatus status) {
        ResponseStructure<T> response = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return new ResponseEntity<>(response, status);
    }

    public static <T> ResponseEntity<ErrorStructure<T>> errorResponse(T data, String message, HttpStatus status) {
        ErrorStructure<T> error = ErrorStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return new ResponseEntity<>(error, status);
    }
}
