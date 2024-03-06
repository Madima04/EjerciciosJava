package org.example.dto.output;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TripOutput {
    private int id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private List<ClientOutputSimple> passangersIds;
    private String status;
}
