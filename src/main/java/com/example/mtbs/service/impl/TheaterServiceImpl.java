package com.example.mtbs.service.impl;

import com.example.mtbs.dto.TheaterRegistrationRequest;
import com.example.mtbs.dto.TheaterRegistrationResponse;
import com.example.mtbs.dto.TheaterUpdateRequest;
import com.example.mtbs.entity.Theater;
import com.example.mtbs.entity.TheaterOwner;
import com.example.mtbs.exception.TheaterDoesNotExistException;
import com.example.mtbs.exception.UserDoesNotExistByEmailException;
import com.example.mtbs.mapper.TheaterRegistrationMapper;
import com.example.mtbs.mapper.TheaterUpdationMapper;
import com.example.mtbs.repository.TheaterOwnerRepository;
import com.example.mtbs.repository.TheaterRepository;
import com.example.mtbs.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    private final TheaterOwnerRepository ownerRepository;

    private final TheaterRegistrationMapper theaterRegistrationMapper;
    private final TheaterUpdationMapper theaterUpdationMapper;

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

    @Override
    public TheaterRegistrationResponse updateTheater(String theaterId, TheaterUpdateRequest theaterUpdateRequest) {
        Optional<Theater> theaters = theaterRepository.findById(theaterId);
        if (theaters != null) {
            Theater theater = theaters.get();
            TheaterOwner owner = ownerRepository.findByEmail(theaterUpdateRequest.email() != null ? theaterUpdateRequest.email() : theater.getCreatedBy());
            if (owner == null) {
                throw new UserDoesNotExistByEmailException("There is no theater owner with this email");
            }
            return theaterRegistrationMapper.mapTheaterResponse(theaterRepository.save(theaterUpdationMapper.toUpdateTheater(theater, theaterUpdateRequest, owner)));
        }
        else {
            throw new TheaterDoesNotExistException("There is no theater with such id " + theaterId);
        }
    }

    @Override
    public TheaterRegistrationResponse findTheater(String theaterId) {
        Theater theater = theaterRepository.findById(theaterId).get();
        if (theater != null) {
            return theaterRegistrationMapper.mapTheaterResponse(theater);
        }
        throw new TheaterDoesNotExistException("There is no theater with such id " + theaterId);
    }

}
