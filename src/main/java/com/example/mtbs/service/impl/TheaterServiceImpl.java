package com.example.mtbs.service.impl;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.exception.UserDoesNotExistByEmailException;
import com.example.mtbs.mapper.TheaterRegistrationMapper;
import com.example.mtbs.repository.TheaterOwnerRepository;
import com.example.mtbs.repository.TheaterRepository;
import com.example.mtbs.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    private final TheaterOwnerRepository ownerRepository;

    private final TheaterRegistrationMapper theaterRegistrationMapper;

    @Override
    public TheaterRegistrationResponse registerTheater(String email, TheaterRegistrationRequest theaterRegistrationRequest) {

        TheaterOwner owner = ownerRepository.findByEmail(email);

        if (owner != null) {
            return theaterRegistrationMapper.mapTheaterResponse(theaterRepository.save(theaterRegistrationMapper.mapTheater(theaterRegistrationRequest, owner)));
        }
        else {
            throw new UserDoesNotExistByEmailException("There is no theater owner with this email");
        }
    }

}
