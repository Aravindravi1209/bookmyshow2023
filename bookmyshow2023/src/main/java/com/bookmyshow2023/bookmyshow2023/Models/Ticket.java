package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Show show;
    // 1 : M
    // 1  : 1  // if no cancellation -> @OneToMany
    @ManyToMany
    private List<ShowSeat> showSeats;

    private double amount;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Date timeOfBooking;
}
