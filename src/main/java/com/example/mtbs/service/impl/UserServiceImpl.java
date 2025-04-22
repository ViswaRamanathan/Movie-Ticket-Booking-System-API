package com.example.mtbs.service.impl;


import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.entity.User;
import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.Role;
import com.example.mtbs.repository.UserRepository;
import com.example.mtbs.service.UserService;
import com.example.mtbs.exception.UserAlreadyExistByEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails saveUser(UserDetails userDetails) {
        if(userRepository.existsByEmail(userDetails.getEmail())) {
            throw new UserAlreadyExistByEmailException("There is a user already registered with this email "+userDetails.getEmail());
        }
        else{
            UserDetails newUser;
            if(userDetails.getRole() == Role.USER){
                newUser = new User();
            } else {
                newUser = new TheaterOwner();
            }
            newUser.setUsername(userDetails.getUsername());
            newUser.setEmail(userDetails.getEmail());
            newUser.setPassword(userDetails.getPassword());
            newUser.setRole(userDetails.getRole());
            newUser.setDateOfBirth(userDetails.getDateOfBirth());
            newUser.setPhoneNumber(userDetails.getPhoneNumber());
            return userRepository.save(newUser);
        }
    }
}
