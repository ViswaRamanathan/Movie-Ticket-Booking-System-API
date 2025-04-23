package com.example.mtbs.service;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetails;

public interface UserService {

    public UserDetails saveUser(UserRegistrationRequest userRegistrationRequest);

    public UserUpdationResponse updateUser(String email, UserUpdationRequest userUpdationRequest);
}
