package com.example.mtbs.controller;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;
import com.example.mtbs.dto.TheaterUpdateRequest;
import com.example.mtbs.service.TheaterService;
import com.example.mtbs.utility.ResponseBuilder;
import com.example.mtbs.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/register-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> addTheater(@RequestParam String email, @RequestBody @Valid TheaterRegistrationRequest theater) {
        return ResponseBuilder.successResponse(theaterService.registerTheater(email, theater),"Theater Created Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> updateTheater(@RequestParam String theaterId, @RequestBody @Valid TheaterUpdateRequest theater) {
        return ResponseBuilder.successResponse(theaterService.updateTheater(theaterId, theater), "Theater Updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/fetch-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> fetchTheater(@RequestParam String theaterId) {
        return ResponseBuilder.successResponse(theaterService.findTheater(theaterId),"Theater Found Successfully", HttpStatus.FOUND);
    }
}
