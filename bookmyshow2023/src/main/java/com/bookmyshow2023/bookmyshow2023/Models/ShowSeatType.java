package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_seattype_mapping")
@Getter
@Setter
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private double price;

}
