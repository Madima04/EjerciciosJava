package com.example.block16SpringCloudTicket.application;

import org.example.dto.input.TripSimplifyInput;
import org.example.dto.output.TripSimplifyOutput;

public interface TripSimplifyService {
    TripSimplifyOutput addTripSimplify(TripSimplifyInput tripSimplifyInput);

    TripSimplifyOutput updateTripSimplify(Integer id, TripSimplifyInput tripSimplifyInput);

    TripSimplifyOutput comparTicket(int id, int cantidad);
}
