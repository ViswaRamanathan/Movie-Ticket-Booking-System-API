package com.example.mtbs.service.impl;


import com.example.mtbs.dto.UserRegistrationRequest;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.Role;
import com.example.mtbs.mapper.UserRegistrationMapper;
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
}
