package com.example.block16springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    private int id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private List<Client> passangers;
    private String status;
}
