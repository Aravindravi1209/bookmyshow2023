package com.bookmyshow2023.bookmyshow2023.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private double amount;
    private String referenceId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    //one ticket can have many payments(failures, as well as success)
    @ManyToOne
    private Ticket ticket;
}
