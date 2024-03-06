package org.example.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.ClientOutputSimple;
import org.example.dto.output.TripOutputSimple;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutput {
    private int passengerId;
    private int tripId;
    private String passengerName;
    private String passengerSurname;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private Date departureDate;
    private Date arrivalDate;
}
