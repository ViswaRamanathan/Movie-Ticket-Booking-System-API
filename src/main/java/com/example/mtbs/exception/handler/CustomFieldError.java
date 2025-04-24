package com.example.mtbs.exception.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomFieldError {
    String field;
    Object rejectedValue;
    String message;
}
