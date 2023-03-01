package com.bookmyshow2023.bookmyshow2023.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Actor extends BaseModel{
    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;


}
