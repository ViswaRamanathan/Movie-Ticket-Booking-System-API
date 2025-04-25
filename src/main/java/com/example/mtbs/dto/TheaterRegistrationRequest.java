package com.example.mtbs.dto;

import jakarta.validation.constraints.NotNull;

public record TheaterRegistrationRequest(
        @NotNull
        String name,
        @NotNull
        String address,
        @NotNull
        String city,
        @NotNull
        String landmark
) {
}
