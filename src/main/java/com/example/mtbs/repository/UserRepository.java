package com.example.mtbs.repository;

import com.example.mtbs.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, String> {

    boolean existsByEmail(String email);

    UserDetail findByEmail(String email);

}
