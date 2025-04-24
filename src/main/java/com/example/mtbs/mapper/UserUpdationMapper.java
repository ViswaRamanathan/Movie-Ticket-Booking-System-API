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
        userDetails.setUsername(uur.username());
        userDetails.setDateOfBirth(uur.dateOfBirth());
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
