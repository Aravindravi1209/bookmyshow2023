package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Models.Theatre;
import com.bookmyshow2023.bookmyshow2023.exceptions.CityNotFoundException;
import com.bookmyshow2023.bookmyshow2023.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheatreController {

    private TheatreService theatreService;
    @Autowired
    public TheatreController(TheatreService theatreService)
    {
        this.theatreService=theatreService;
    }

    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {
        return this.theatreService.createTheatre(name,address,cityId);
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity)
    {
        return this.theatreService.addAuditorium(theatreId,name,capacity);
    }
}
