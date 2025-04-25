package com.example.mtbs.dto;

public record TheaterRegistrationResponse(
        String name,
        String createdBy,
        String address,
        String city,
        String landmark,
        long createdAt,
        long updatedAt
) {
}
