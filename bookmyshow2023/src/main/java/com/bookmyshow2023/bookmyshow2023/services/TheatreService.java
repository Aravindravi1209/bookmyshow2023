package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.Auditorium;
import com.bookmyshow2023.bookmyshow2023.Models.City;
import com.bookmyshow2023.bookmyshow2023.Models.Theatre;
import com.bookmyshow2023.bookmyshow2023.exceptions.CityNotFoundException;
import com.bookmyshow2023.bookmyshow2023.repositories.AuditoriumRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.CityRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheatreService {

    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository, AuditoriumRepository auditoriumRepository)
    {
        this.theatreRepository=theatreRepository;
        this.cityRepository=cityRepository;
        this.auditoriumRepository=auditoriumRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {

        Optional<City> cityOptional = cityRepository.findById(cityId);
        if(!cityOptional.isPresent())
        {
            throw new CityNotFoundException("No City Was Found for the given Id");
        }

        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City dbCity = cityOptional.get();
        dbCity.getTheatres().add(savedTheatre);
        this.cityRepository.save(dbCity);
        return savedTheatre;
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity)
    {
        Theatre theatre = theatreRepository.findById(theatreId).get();
        Auditorium auditorium = new Auditorium();
        auditorium.setTheatre(theatre);
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);
        theatre.getAuditoriums().add(savedAuditorium);
        return theatreRepository.save(theatre);
    }
}
