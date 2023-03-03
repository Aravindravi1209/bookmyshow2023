package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;

    @Enumerated(EnumType.STRING)
    private List<Language> languages;

    @ManyToMany
    private List<Actor> actors;

    private int length;
    private double rating;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;


}
