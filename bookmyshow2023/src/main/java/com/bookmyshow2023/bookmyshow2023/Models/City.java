package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Theatre> theatres;
}
