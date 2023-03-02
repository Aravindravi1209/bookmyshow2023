package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Models.Auditorium;
import com.bookmyshow2023.bookmyshow2023.Models.Language;
import com.bookmyshow2023.bookmyshow2023.Models.SeatType;
import com.bookmyshow2023.bookmyshow2023.Models.Show;
import com.bookmyshow2023.bookmyshow2023.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class ShowController {
    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }
    public Show createShow(Long movieId, Date startTime, Date endTime,
                           Long audioriumId, Map<SeatType,Integer> seatPricing, Language language)
    {
        return this.showService.createShow(movieId,startTime,endTime,audioriumId,seatPricing,language);
    }
}
