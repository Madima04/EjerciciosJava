package com.example.block16springcloud.application;

import com.example.block16springcloud.application.impl.TripServiceImpl;
import org.example.dto.input.TripInput;
import org.example.dto.output.TripOutput;
import org.example.dto.output.TripOutputSimple;

public interface TripService {
    TripOutputSimple addTrip(TripInput tripInput);
    TripOutput getTrip(Integer id);
    TripOutput updateTrip(Integer id, TripInput tripInput);
    boolean deleteTrip(Integer id);
    Iterable<TripOutputSimple> getTrips();
    TripOutput addClientToTrip(Integer id, Integer clientId);

    TripOutput updateTripStatus(Integer tripId, String tripStatus);

    Boolean verifyTrip(Integer tripId);
}
