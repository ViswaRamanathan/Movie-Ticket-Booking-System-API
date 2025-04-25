package com.example.mtbs.dto;

import com.example.mtbs.entity.TheaterOwner;

public record TheaterUpdateRequest(
        String name,
        String address,
        String city,
        String landmark,
        String email
) {
}
