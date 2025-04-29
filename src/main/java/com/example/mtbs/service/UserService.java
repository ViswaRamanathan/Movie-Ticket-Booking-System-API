package com.example.mtbs.service;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetail;

public interface UserService {

    public UserDetail saveUser(UserRegistrationRequest userRegistrationRequest);

    public UserUpdationResponse updateUser(String email, UserUpdationRequest userUpdationRequest);

    public String deactivateUser(String email);
}
