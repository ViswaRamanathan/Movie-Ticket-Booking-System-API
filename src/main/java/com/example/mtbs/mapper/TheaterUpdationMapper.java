package com.example.mtbs.mapper;

import com.example.mtbs.dto.TheaterUpdateRequest;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterUpdationMapper {

    public Theater toUpdateTheater(Theater theater, TheaterUpdateRequest theaterUpdateRequest, TheaterOwner owner){
        if (theaterUpdateRequest.name() != null)
            theater.setName(theaterUpdateRequest.name());
        if (theaterUpdateRequest.address() != null)
            theater.setAddress(theaterUpdateRequest.address());
        if (theaterUpdateRequest.city() != null)
            theater.setCity(theaterUpdateRequest.city());
        if (theaterUpdateRequest.landmark() != null)
            theater.setLandmark(theaterUpdateRequest.landmark());
        if(owner != null) {
            theater.setOwner(owner);
            theater.setCreatedBy(owner.getEmail());
        }
        return theater;
    }
}
