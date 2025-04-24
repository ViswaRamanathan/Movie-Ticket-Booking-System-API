package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserUpdationMapper {

    public UserDetails toUserDetails(UserUpdationRequest uur) {
        UserDetails userDetails = new UserDetails();
        if(uur.username() != null)
            userDetails.setUsername(uur.username());
        if(uur.dateOfBirth() != null)
            userDetails.setDateOfBirth(uur.dateOfBirth());
        if(uur.phoneNumber() != null)
            userDetails.setPhoneNumber(uur.phoneNumber());
        return userDetails;
    }

    public UserUpdationResponse toUserUpdationResponse(UserDetails userDetails) {
        return new UserUpdationResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getPhoneNumber(),
                userDetails.getDateOfBirth(),
                userDetails.getUpdatedAt()
        );
    }
}
