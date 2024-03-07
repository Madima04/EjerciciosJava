package com.example.block16SpringCloudTicket.application.impl;

import com.example.block16SpringCloudTicket.application.TripSimplifyService;
import com.example.block16SpringCloudTicket.controller.TripSimplifyInterface;
import com.example.block16SpringCloudTicket.domain.TripSimplify;
import com.example.block16SpringCloudTicket.repository.TripSimplifyRepository;
import org.example.dto.input.TripSimplifyInput;
import org.example.dto.output.TripSimplifyOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripSimplifyServiceImpl implements TripSimplifyService {
    @Autowired
    TripSimplifyRepository tripSimplifyRepository;
    @Autowired
    TripSimplifyInterface tripSimplifyInterface;

    @Override
    public TripSimplifyOutput addTripSimplify(TripSimplifyInput tripSimplifyInput) {
        TripSimplify tripSimplify = new TripSimplify();
        tripSimplify.setTripId(tripSimplifyInput.getTripId());
        tripSimplify.setSeats(tripSimplifyInput.getSeat());
        tripSimplifyRepository.save(tripSimplify);
        tripSimplifyInterface.sendTicket(tripSimplify.toTripSimplifyOutput());
        return tripSimplify.toTripSimplifyOutput();
    }

    @Override
    public TripSimplifyOutput updateTripSimplify(Integer id, TripSimplifyInput tripSimplifyInput) {
        TripSimplify tripSimplify = tripSimplifyRepository.findById(id).get();
        tripSimplify.setTripId(tripSimplifyInput.getTripId());
        tripSimplify.setSeats(tripSimplifyInput.getSeat());
        tripSimplifyRepository.save(tripSimplify);
        return tripSimplify.toTripSimplifyOutput();
    }

    @Override
    public TripSimplifyOutput comparTicket(int id, int cantidad) {
        TripSimplify tripSimplify = tripSimplifyRepository.findById(id).get();
        System.out.println("TripSimplify " + tripSimplify.toString());
        if (tripSimplify.getSeats() + cantidad <= 20) {
            tripSimplify.setSeats(tripSimplify.getSeats() + cantidad);
            tripSimplifyRepository.save(tripSimplify);
            return tripSimplify.toTripSimplifyOutput();
        }
        return null;
    }
}
