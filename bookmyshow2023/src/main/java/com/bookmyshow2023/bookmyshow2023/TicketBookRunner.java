package com.bookmyshow2023.bookmyshow2023;

import com.bookmyshow2023.bookmyshow2023.controllers.TicketController;
import com.bookmyshow2023.bookmyshow2023.exceptions.ShowSeatNotAvailableException;

import java.util.List;

public class TicketBookRunner implements Runnable{
    private TicketController ticketController;
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
    public TicketBookRunner(TicketController ticketController, Long showId, List<Long> showSeatIds, Long userId)
    {
        this.ticketController=ticketController;
        this.showSeatIds=showSeatIds;
        this.showId=showId;
        this.userId=userId;
    }
    @Override
    public void run() {
        try {
            this.ticketController.bookTicket(showId,showSeatIds,userId);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());;
        }
    }
}
