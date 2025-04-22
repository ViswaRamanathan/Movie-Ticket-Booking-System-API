package com.example.mtbs.dto;

import java.time.LocalDate;

public record UserUpdationRequest(
        String email,
        String username,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
