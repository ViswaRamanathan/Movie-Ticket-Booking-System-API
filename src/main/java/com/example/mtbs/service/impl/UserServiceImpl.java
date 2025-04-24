package com.example.mtbs.service.impl;

import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.dto.UserUpdationRequest;
import com.example.mtbs.dto.UserUpdationResponse;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.Role;
import com.example.mtbs.exception.UserDoesNotExistByEmailException;
import com.example.mtbs.mapper.UserRegistrationMapper;
import com.example.mtbs.mapper.UserUpdationMapper;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import com.example.mtbs.exception.UserAlreadyExistByEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRegistrationMapper userRegistrationMapper;

    private final UserUpdationMapper userUpdationMapper;

    @Override
    public UserDetails saveUser(UserRegistrationRequest userRegistrationRequest) {
        if(userRepository.existsByEmail(userRegistrationRequest.email())) {
            throw new UserAlreadyExistByEmailException("There is a user already registered with this email "+userRegistrationRequest.email());
        }
        else{
            if(userRegistrationRequest.role() == Role.USER){
                return userRepository.save(userRegistrationMapper.toUser(userRegistrationRequest));
            } else {
                return userRepository.save(userRegistrationMapper.toTheaterOwner(userRegistrationRequest));
            }
        }
    }

    @Override
    public UserUpdationResponse updateUser(String email, UserUpdationRequest userUpdationRequest) {
        if(userRepository.existsByEmail(email)) {
            UserDetails userDetails = userRepository.findByEmail(email);
            if(userUpdationRequest.username() != null)
                userDetails.setUsername(userUpdationRequest.username());
            if(userUpdationRequest.dateOfBirth() != null)
                userDetails.setDateOfBirth(userUpdationRequest.dateOfBirth());
            if(userUpdationRequest.phoneNumber() != null)
                userDetails.setPhoneNumber(userUpdationRequest.phoneNumber());
            return userUpdationMapper.toUserUpdationResponse(userRepository.save(userDetails));
        }
        else{
            throw new UserDoesNotExistByEmailException("There is no user registered with this email "+email);
        }
    }

    @Override
    public String deactivateUser(String email) {
        if(userRepository.existsByEmail(email)) {
            UserDetails userDetails = userRepository.findByEmail(email);
            userDetails.setDeleted(true);
            userRepository.save(userDetails);
            return "User deactivated successfully";
        }
        else{
            throw new UserDoesNotExistByEmailException("There is no user registered with this email "+email);
        }
    }
}
