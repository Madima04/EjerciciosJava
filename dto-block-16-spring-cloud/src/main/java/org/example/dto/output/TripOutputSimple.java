package org.example.dto.output;

import lombok.Data;
import java.util.Date;
@Data
public class TripOutputSimple {
    private int id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private int seats;
    private String status;
}
