package com.example.mtbs.dto;

import com.example.mtbs.enums.Role;

import java.time.LocalDate;

public record UserRegistrationRequest(
        String username,
        String email,
        String password,
        String phoneNumber,
        LocalDate dateOfBirth,
        Role role
) {
}
