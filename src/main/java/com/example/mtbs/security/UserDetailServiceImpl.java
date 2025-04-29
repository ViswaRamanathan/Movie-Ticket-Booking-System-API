package com.example.mtbs.security;

import com.example.mtbs.entity.UserDetail;
import com.example.mtbs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetail userDetail = userRepository.findByEmail(username);

        if (userDetail == null)
            throw new UsernameNotFoundException("user not found by name: " + username);

        return User.builder()
                .username(userDetail.getEmail())
                .password(userDetail.getPassword())
                .authorities(userDetail.getRole().name())
                .build();
    }
}
