package com.example.mtbs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

public record UserUpdationRequest(
        @Min(4) @Max(15)
        String username,
        @Min(10) @Max(10)
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
