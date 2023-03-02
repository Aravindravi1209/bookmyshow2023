package com.bookmyshow2023.bookmyshow2023.controllers;

import com.bookmyshow2023.bookmyshow2023.Models.Ticket;
import com.bookmyshow2023.bookmyshow2023.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId)
    {
        return null;
    }
}
