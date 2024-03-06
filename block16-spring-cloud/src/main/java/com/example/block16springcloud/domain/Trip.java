package com.example.block16springcloud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.input.TripInput;
import org.example.dto.output.ClientOutputSimple;
import org.example.dto.output.TripOutput;
import org.example.dto.output.TripOutputSimple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip {
    @Id
    @GeneratedValue
    private int id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    @OneToMany
    private List<Client> passangers;
    private String status;

    public TripOutputSimple toTripOutputSimple() {
        TripOutputSimple tripOutputSimple = new TripOutputSimple();
        tripOutputSimple.setOrigin(this.origin);
        tripOutputSimple.setDestination(this.destination);
        tripOutputSimple.setDepartureDate(this.departureDate);
        tripOutputSimple.setArrivalDate(this.arrivalDate);
        tripOutputSimple.setStatus(this.status);
        return tripOutputSimple;
    }

    public TripOutput toTripOutput() {
        TripOutput tripOutput = new TripOutput();
        tripOutput.setId(this.id);
        tripOutput.setOrigin(this.origin);
        tripOutput.setDestination(this.destination);
        tripOutput.setDepartureDate(this.departureDate);
        tripOutput.setArrivalDate(this.arrivalDate);
        tripOutput.setPassangersIds(getPassangersOutput());
        tripOutput.setStatus(this.status);
        return tripOutput;
    }

    private List<ClientOutputSimple> getPassangersOutput() {
        List<ClientOutputSimple> passangersOutput = new ArrayList<>();
        for (Client client : this.passangers) {
            passangersOutput.add(client.toClientOutputSimple());
        }
        return passangersOutput;
    }
}
