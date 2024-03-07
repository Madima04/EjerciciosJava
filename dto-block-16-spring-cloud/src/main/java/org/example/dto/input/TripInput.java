package org.example.dto.input;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TripInput {
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
}
