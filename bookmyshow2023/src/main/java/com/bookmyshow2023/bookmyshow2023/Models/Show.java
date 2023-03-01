package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<ShowSeatType> showSeatTypes;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;

}
