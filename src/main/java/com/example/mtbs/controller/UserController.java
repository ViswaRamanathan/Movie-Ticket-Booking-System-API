package com.example.mtbs.controller;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserRegistrationResponse;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.mapper.UserRegistrationMapper;
import com.example.mtbs.service.UserService;
import com.example.mtbs.utility.ResponseBuilder;
import com.example.mtbs.utility.ResponseStructure;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseStructure<UserRegistrationResponse>> saveUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
        return ResponseBuilder.successResponse(userRegistrationMapper.toUserDetails(userService.saveUser(userRegistrationRequest)),"User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserUpdationResponse>> updateUser(@RequestParam String email, @RequestBody UserUpdationRequest userUpdationRequest) {
        return ResponseBuilder.successResponse(userService.updateUser(email, userUpdationRequest), "User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<ResponseStructure<String>> deactivateUser(@PathVariable String email) {
        return ResponseBuilder.successResponse(userService.deactivateUser(email), "User deactivated successfully", HttpStatus.OK);
    }

}
