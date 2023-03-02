package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.*;
import com.bookmyshow2023.bookmyshow2023.repositories.AuditoriumRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.ShowRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {

//    TODO : Movies and Pricing
    private AuditoriumRepository auditoriumRepository;
    private ShowRepository showRepository;

    private ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowService(AuditoriumRepository auditoriumRepository, ShowRepository showRepository,
                       ShowSeatRepository showSeatRepository) {
        this.auditoriumRepository = auditoriumRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
    }

    public Show createShow(Long movieId, Date startTime, Date endTime,
                           Long audioriumId, Map<SeatType,Integer> seatPricing, Language language)
    {
        Show show = new Show();
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setLanguage(language);

        Auditorium auditorium = auditoriumRepository.findById(audioriumId).get();
        show.setAuditorium(auditorium);

        Show savedShow = showRepository.save(show);

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(Seat seat : auditorium.getSeats())
        {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(savedShow);
            showSeat.setSeat(seat);
            showSeat.setState(ShowSeatState.AVAILABLE);
            savedShowSeats.add(this.showSeatRepository.save(showSeat));
        }
        savedShow.setShowSeats(savedShowSeats);
        return this.showRepository.save(savedShow);
    }
}
