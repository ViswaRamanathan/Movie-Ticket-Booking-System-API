package com.example.mtbs.entity;

import com.example.mtbs.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@SQLDelete(sql = "update userdetails set deleted = true where email = ?")
@Where(clause = "deleted  = false")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    private String password;
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate dateOfBirth;
    private long createdAt;
    private long updatedAt;
    private boolean deleted = false;
    private long deletedAt;

}
