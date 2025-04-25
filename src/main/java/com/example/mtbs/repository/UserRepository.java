package com.example.mtbs.repository;

import com.example.mtbs.entity.UserDetails;
import com.example.mtbs.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);

}
