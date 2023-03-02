package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.City;
import com.bookmyshow2023.bookmyshow2023.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;
    @Autowired
    public CityService(CityRepository cityRepository)
    {
        this.cityRepository=cityRepository;
    }

    public City addCity(String name)
    {
        City newCity = new City();
        newCity.setName(name);
        return this.cityRepository.save(newCity);
    }
}
