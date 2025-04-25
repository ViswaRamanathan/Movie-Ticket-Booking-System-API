package com.example.mtbs.repository;

import com.example.mtbs.entity.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterOwnerRepository extends JpaRepository<TheaterOwner, String> {

    TheaterOwner findByEmail(String email);
}
