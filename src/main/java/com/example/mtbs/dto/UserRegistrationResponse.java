package com.example.mtbs.dto;

import com.example.mtbs.enums.Role;

import java.time.LocalDate;

public record UserRegistrationResponse(
        String username,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        long createdAt,
        long updatedAt,
        String userId,
        Role role
) {
}
