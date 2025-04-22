package com.example.mtbs.controller;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserRegistrationResponse;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.mapper.UserRegistrationMapper;
import com.example.mtbs.service.UserService;
import com.example.mtbs.utility.ResponseBuilder;
import com.example.mtbs.utility.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping
    public ResponseEntity<ResponseStructure<UserRegistrationResponse>> saveUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return ResponseBuilder.successResponse(userRegistrationMapper.toUserDetails(userService.saveUser(userRegistrationRequest)),"User created successfully", HttpStatus.CREATED);
    }

}
