package com.example.mtbs.controller;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserRegistrationResponse;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.mapper.UserRegistrationMapper;
import com.example.mtbs.service.UserService;
import com.example.mtbs.utility.ResponseBuilder;
import com.example.mtbs.utility.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserRegistrationResponse>> saveUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return ResponseBuilder.successResponse(userRegistrationMapper.toUserDetails(userService.saveUser(userRegistrationRequest)),"User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/register")
    public ResponseEntity<ResponseStructure<UserUpdationResponse>> updateUser(@RequestBody UserUpdationRequest userUpdationRequest) {
        return ResponseBuilder.successResponse(userService.updateUser(userUpdationRequest), "User updated successfully", HttpStatus.OK);
    }
}
