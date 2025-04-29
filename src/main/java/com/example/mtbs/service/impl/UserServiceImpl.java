package com.example.mtbs.service.impl;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetail;
import com.example.mtbs.enums.Role;
import com.example.mtbs.exception.UserDoesNotExistByEmailException;
import com.example.mtbs.mapper.UserRegistrationMapper;
import com.example.mtbs.mapper.UserUpdationMapper;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import com.example.mtbs.exception.UserAlreadyExistByEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRegistrationMapper userRegistrationMapper;

    private final UserUpdationMapper userUpdationMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetail saveUser(UserRegistrationRequest userRegistrationRequest) {
        if(userRepository.existsByEmail(userRegistrationRequest.email())) {
            throw new UserAlreadyExistByEmailException("There is a user already registered with this email "+userRegistrationRequest.email());
        }
        else{
            UserDetail userDetail = new UserDetail();
            userDetail.setPassword(passwordEncoder.encode(userRegistrationRequest.password()));
            if(userRegistrationRequest.role() == Role.USER){
                return userRepository.save(userRegistrationMapper.toUser(userDetail, userRegistrationRequest));
            } else {
                return userRepository.save(userRegistrationMapper.toTheaterOwner(userDetail, userRegistrationRequest));
            }
        }
    }

    @Override
    public UserUpdationResponse updateUser(String email, UserUpdationRequest userUpdationRequest) {
        if(userRepository.existsByEmail(email)) {
            UserDetail userDetail = userRepository.findByEmail(email);
            userDetail = userUpdationMapper.toUserDetails(userUpdationRequest);
            return userUpdationMapper.toUserUpdationResponse(userRepository.save(userDetail));
        }
        else{
            throw new UserDoesNotExistByEmailException("There is no user registered with this email "+email);
        }
    }

    @Override
    public String deactivateUser(String email) {
        if(userRepository.existsByEmail(email)) {
            UserDetail userDetail = userRepository.findByEmail(email);
            userDetail.setDeleted(true);
            userRepository.save(userDetail);
            return "User deactivated successfully";
        }
        else{
            throw new UserDoesNotExistByEmailException("There is no user registered with this email "+email);
        }
    }
}
