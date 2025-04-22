package com.example.mtbs.utility;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorStructure<T> {

    private T data;
    private String message;
    private int status;

}
