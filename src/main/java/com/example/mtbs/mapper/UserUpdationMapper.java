package com.example.mtbs.mapper;

import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetail;
import org.springframework.stereotype.Component;

@Component
public class UserUpdationMapper {

    public UserDetail toUserDetails(UserUpdationRequest uur) {
        UserDetail userDetail = new UserDetail();
        if(uur.username() != null)
            userDetail.setUsername(uur.username());
        if(uur.dateOfBirth() != null)
            userDetail.setDateOfBirth(uur.dateOfBirth());
        if(uur.phoneNumber() != null)
            userDetail.setPhoneNumber(uur.phoneNumber());
        return userDetail;
    }

    public UserUpdationResponse toUserUpdationResponse(UserDetail userDetail) {
        return new UserUpdationResponse(
                userDetail.getUserId(),
                userDetail.getUsername(),
                userDetail.getPhoneNumber(),
                userDetail.getDateOfBirth(),
                userDetail.getUpdatedAt()
        );
    }
}
