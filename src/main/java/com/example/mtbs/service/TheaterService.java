package com.example.mtbs.service;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;
import com.example.mtbs.dto.TheaterUpdateRequest;

public interface TheaterService {

    public TheaterRegistrationResponse registerTheater(String email, TheaterRegistrationRequest theaterRegistrationRequest);

    public TheaterRegistrationResponse updateTheater(String theaterId, TheaterUpdateRequest theaterUpdateRequest);

    public TheaterRegistrationResponse findTheater(String theaterId);
}
