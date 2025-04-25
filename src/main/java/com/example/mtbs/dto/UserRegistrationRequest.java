package com.example.mtbs.dto;

import com.example.mtbs.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull
        String username,
        @NotNull @Email
        String email,
        @NotNull
        String password,
        @NotNull
        String phoneNumber,
        @NotNull
        LocalDate dateOfBirth,
        @NotNull
        Role role
) {
}
