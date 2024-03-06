package org.example.dto.output;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TripOutputSimple {
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
}
