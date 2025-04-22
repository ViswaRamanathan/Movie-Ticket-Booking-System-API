package com.example.mtbs.exception.handler;

import com.example.mtbs.exception.UserAlreadyExistByEmailException;
import com.example.mtbs.utility.ErrorStructure;
import com.example.mtbs.utility.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleUserAlreadyExistByEmailException(UserAlreadyExistByEmailException ue){
        return ResponseBuilder.errorResponse(ue.getMessage(), "Email already registred", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorStructure<String>> handleInvalidEnum(HttpMessageNotReadableException r){
        return ResponseBuilder.errorResponse(r.getMessage(), "Role does not exist", HttpStatus.CONFLICT);
    }

}


