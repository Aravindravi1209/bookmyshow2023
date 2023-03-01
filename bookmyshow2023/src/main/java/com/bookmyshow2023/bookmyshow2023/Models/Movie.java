package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getCasts() {
        return actors;
    }

    public void setCasts(List<Actor> actor) {
        this.actors = actor;
    }
}
