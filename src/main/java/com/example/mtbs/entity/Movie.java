package com.example.mtbs.entity;

import com.example.mtbs.enums.Certificate;
import com.example.mtbs.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Set;

@Entity
@Setter
@Getter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String movieId;

    private String title;
    private String description;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = {@JoinColumn(name = "movieId")})
    @Column(name = "cast_name")
    private Set<String> cast;

    private Duration duration;

    @Enumerated(EnumType.STRING)
    private Certificate certificate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

}
