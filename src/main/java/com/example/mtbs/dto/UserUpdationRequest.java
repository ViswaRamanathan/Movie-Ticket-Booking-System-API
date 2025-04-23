package com.example.mtbs.dto;

import java.time.LocalDate;

public record UserUpdationRequest(
        String username,
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
