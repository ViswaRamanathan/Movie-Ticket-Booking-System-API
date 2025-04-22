package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserRegistrationResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    private void populateCommonFields(UserDetails userDetail, UserRegistrationRequest urr) {
        userDetail.setUsername(urr.username());
        userDetail.setPassword(urr.password());
        userDetail.setRole(urr.role());
        userDetail.setDateOfBirth(urr.dateOfBirth());
        userDetail.setPhoneNumber(urr.phoneNumber());
        userDetail.setEmail(urr.email());
    }

    public User toUser(UserRegistrationRequest urr) {
        User user = new User();
        populateCommonFields(user, urr);
        return user;
    }

    public TheaterOwner toTheaterOwner(UserRegistrationRequest urr) {
        TheaterOwner theaterOwner = new TheaterOwner();
        populateCommonFields(theaterOwner, urr);
        return theaterOwner;
    }

    public UserRegistrationResponse toUserDetails(UserDetails userDetails) {
        return new UserRegistrationResponse(
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getDateOfBirth(),
                userDetails.getCreatedAt(),
                userDetails.getUpdatedAt(),
                userDetails.getUserId(),
                userDetails.getRole()
        );
    }

}
