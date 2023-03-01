package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

}
