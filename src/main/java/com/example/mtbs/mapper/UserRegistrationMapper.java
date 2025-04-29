package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserRegistrationResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetail;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    private void populateCommonFields(UserDetail userDetail, UserRegistrationRequest urr) {
        userDetail.setUsername(urr.username());
        userDetail.setRole(urr.role());
        userDetail.setDateOfBirth(urr.dateOfBirth());
        userDetail.setPhoneNumber(urr.phoneNumber());
        userDetail.setEmail(urr.email());
    }

    public User toUser(UserDetail ud, UserRegistrationRequest urr) {
        User user = new User();
        populateCommonFields(user, urr);
        user.setPassword(ud.getPassword());
        return user;
    }

    public TheaterOwner toTheaterOwner(UserDetail ud, UserRegistrationRequest urr) {
        TheaterOwner theaterOwner = new TheaterOwner();
        populateCommonFields(theaterOwner, urr);
        theaterOwner.setPassword(ud.getPassword());
        return theaterOwner;
    }

    public UserRegistrationResponse toUserDetails(UserDetail userDetail) {
        return new UserRegistrationResponse(
                userDetail.getUsername(),
                userDetail.getEmail(),
                userDetail.getPhoneNumber(),
                userDetail.getDateOfBirth(),
                userDetail.getCreatedAt(),
                userDetail.getUpdatedAt(),
                userDetail.getUserId(),
                userDetail.getRole()
        );
    }

}
