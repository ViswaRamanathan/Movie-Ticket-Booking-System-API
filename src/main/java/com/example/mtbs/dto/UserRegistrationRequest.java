package com.example.mtbs.dto;

import com.example.mtbs.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull @Min(4) @Max(15)
        String username,
        @NotNull @Email
        String email,
        @NotNull @Min(4) @Max(10)
        String password,
        @NotNull @Min(10) @Max(10)
        String phoneNumber,
        @NotNull
        LocalDate dateOfBirth,
        @NotNull
        Role role
) {
}
