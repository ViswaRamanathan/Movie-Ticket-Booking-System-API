package com.example.mtbs.repository;

import com.example.mtbs.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
