package com.bookmyshow2023.bookmyshow2023.services;

import com.bookmyshow2023.bookmyshow2023.Models.ShowSeat;
import com.bookmyshow2023.bookmyshow2023.Models.ShowSeatState;
import com.bookmyshow2023.bookmyshow2023.Models.Ticket;
import com.bookmyshow2023.bookmyshow2023.Models.TicketStatus;
import com.bookmyshow2023.bookmyshow2023.exceptions.ShowSeatNotAvailableException;
import com.bookmyshow2023.bookmyshow2023.repositories.ShowRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.ShowSeatRepository;
import com.bookmyshow2023.bookmyshow2023.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    private ShowRepository showRepository;
    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository, ShowRepository showRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds, Long userId) throws ShowSeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatIds);
        for(ShowSeat showSeat: showSeats)
        {
            if(showSeat.getState()!= ShowSeatState.AVAILABLE)
            {
                throw new ShowSeatNotAvailableException(
                        "ShowSeat ID: "+showSeat.getId()+" not available"
                );
            }
        }
        for(ShowSeat showSeat:showSeats)
        {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setBookedBy(userRepository.findById(userId).get());
        ticket.setShow(showRepository.findById(showId).get());
        ticket.setShowSeats(showSeats);
        ticket.setTimeOfBooking(new Date());

        return ticket;
    }
}
