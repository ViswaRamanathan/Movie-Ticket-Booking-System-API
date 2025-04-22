package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;

public class UserUpdationMapper {

    private void populateCommonFields(UserDetails userDetail, UserUpdationRequest uur) {
        userDetail.setUsername(uur.username());
        userDetail.setDateOfBirth(uur.dateOfBirth());
        userDetail.setPhoneNumber(uur.phoneNumber());
        userDetail.setEmail(uur.email());
    }

    public User toUser(UserUpdationRequest uur) {
        User user = new User();
        populateCommonFields(user, uur);
        return user;
    }

    public TheaterOwner toTheaterOwner(UserUpdationRequest uur) {
        TheaterOwner theaterOwner = new TheaterOwner();
        populateCommonFields(theaterOwner, uur);
        return theaterOwner;
    }

    public UserUpdationResponse toUserUpdationResponse(UserDetails userDetails) {
        return new UserUpdationResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getPhoneNumber(),
                userDetails.getDateOfBirth()
        );
    }
}
