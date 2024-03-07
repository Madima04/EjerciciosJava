package com.example.block16SpringCloudTicket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.dto.output.TripSimplifyOutput;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TripSimplify {
    @Id
    @GeneratedValue
    int id;
    int tripId;
    int seats;

    public TripSimplifyOutput toTripSimplifyOutput() {
        TripSimplifyOutput tripSimplifyOutput = new TripSimplifyOutput();
        tripSimplifyOutput.setId(this.id);
        tripSimplifyOutput.setTripId(this.tripId);
        tripSimplifyOutput.setSeat(this.seats);
        return tripSimplifyOutput;
    }
}
