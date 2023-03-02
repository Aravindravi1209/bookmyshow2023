package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Models.City;
import com.bookmyshow2023.bookmyshow2023.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService)
    {
        this.cityService=cityService;
    }

    public City addCity(String name)
    {
        return this.cityService.addCity(name);
    }
}
