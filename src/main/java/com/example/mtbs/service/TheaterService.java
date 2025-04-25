package com.example.mtbs.service;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;

public interface TheaterService {

    public TheaterRegistrationResponse registerTheater(String email, TheaterRegistrationRequest theaterRegistrationRequest);

}
