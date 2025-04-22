package com.example.mtbs.dto;

import java.time.LocalDate;

public record UserUpdationResponse(
        String email,
        String username,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
