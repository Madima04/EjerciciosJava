package com.example.block16SpringCloudTicket.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.dto.output.TicketOutput;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private int passengerId;
    private int tripId;
    private String passengerName;
    private String passengerSurname;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private Date departureDate;
    private Date arrivalDate;

    public TicketOutput toTicketOutput() {
        TicketOutput ticketOutput = new TicketOutput(this.passengerId, this.tripId, this.passengerName, this.passengerSurname, this.passengerEmail, this.tripOrigin, this.tripDestination, this.departureDate, this.arrivalDate);
        return ticketOutput;
    }
}
