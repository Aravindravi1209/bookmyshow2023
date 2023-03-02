package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.*;
import com.bookmyshow2023.bookmyshow2023.exceptions.CityNotFoundException;
import com.bookmyshow2023.bookmyshow2023.repositories.AuditoriumRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.CityRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.SeatRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;

    private SeatRepository seatRepository;
    @Autowired
    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository, SeatRepository seatRepository)
    {
        this.theatreRepository=theatreRepository;
        this.cityRepository=cityRepository;
        this.auditoriumRepository=auditoriumRepository;
        this.seatRepository=seatRepository;
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

    public void addSeats(Long auditoriumId, HashMap<SeatType,Integer> seatCount)
    {
        Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();
        List<Seat> seats = new ArrayList<>();
        for(SeatType seatType:seatCount.keySet())
        {
            for(int i=0;i<seatCount.get(seatType);i++)
            {
                Seat seat = new Seat();
                seat.setSeatType(seatType);
                seat.setSeatNumber(seatType.toString()+ Integer.toString(i+1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = seatRepository.saveAll(seats);
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);
    }
}
