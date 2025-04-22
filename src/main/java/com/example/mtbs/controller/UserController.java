package com.example.mtbs.controller;

import com.example.mtbs.entity.UserDetails;
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

    @PostMapping
    public ResponseEntity<ResponseStructure<UserDetails>> saveUser(@RequestBody UserDetails userDetails) {
        return ResponseBuilder.successResponse(userService.saveUser(userDetails),"User created successfully", HttpStatus.CREATED);
    }

}
