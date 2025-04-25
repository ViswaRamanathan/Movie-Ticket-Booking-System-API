package com.example.mtbs.mapper;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterRegistrationMapper {

    public Theater mapTheater(TheaterRegistrationRequest theaterRegistrationRequest, TheaterOwner owner) {
        Theater theater = new Theater();
        theater.setName(theaterRegistrationRequest.name());
        theater.setAddress(theaterRegistrationRequest.address());
        theater.setCity(theaterRegistrationRequest.city());
        theater.setLandmark(theaterRegistrationRequest.landmark());
        theater.setCreatedBy(owner.getEmail());
        theater.setOwner(owner);
        return theater;
    }

    public TheaterRegistrationResponse mapTheaterResponse(Theater theater) {
        return new TheaterRegistrationResponse(theater.getName(),
                theater.getCreatedBy(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark(),
                theater.getCreatedAt(),
                theater.getUpdatedAt()
        );
    }
}
