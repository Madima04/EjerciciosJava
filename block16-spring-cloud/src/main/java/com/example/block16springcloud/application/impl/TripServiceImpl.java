package com.example.block16springcloud.application.impl;

import com.example.block16springcloud.application.TripService;
import com.example.block16springcloud.controller.TicketInterface;
import com.example.block16springcloud.domain.Client;
import com.example.block16springcloud.domain.Trip;
import com.example.block16springcloud.repository.ClientRepository;
import com.example.block16springcloud.repository.TripRepository;
import org.example.dto.input.TripInput;
import org.example.dto.output.TicketOutput;
import org.example.dto.output.TripOutput;
import org.example.dto.output.TripOutputSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TicketInterface ticketInterface;

    @Override
    public TripOutputSimple addTrip(TripInput tripInput) {
        Trip trip = new Trip();
        trip.setOrigin(tripInput.getOrigin());
        trip.setDestination(tripInput.getDestination());
        trip.setDepartureDate(tripInput.getDepartureDate());
        trip.setArrivalDate(tripInput.getArrivalDate());
        trip.setStatus(tripInput.getStatus());
        tripRepository.save(trip);
        return trip.toTripOutputSimple();
    }

    @Override
    public TripOutput getTrip(Integer id) {
        Trip trip = tripRepository.findById(id).get();
        TripOutput tripOutput = new TripOutput();
        trip.setId(trip.getId());
        trip.setOrigin(trip.getOrigin());
        trip.setDestination(trip.getDestination());
        trip.setDepartureDate(trip.getDepartureDate());
        trip.setArrivalDate(trip.getArrivalDate());
        trip.setPassangers(ClientRepository.findByTrip(trip));
        trip.setStatus(trip.getStatus());
        return trip.toTripOutput();
    }

    @Override
    public TripOutput updateTrip(Integer id, TripInput tripInput) {
        return null;
    }

    @Override
    public boolean deleteTrip(Integer id) {
        return false;
    }

    @Override
    public Iterable<TripOutputSimple> getTrips() {
        return null;
    }

    @Override
    public TripOutput addClientToTrip(Integer id, Integer clientId) {
        TicketOutput ticketOutput;
        Client client = clientRepository.findById(clientId).get();
        Trip trip = tripRepository.findById(id).get();
        if (trip.getPassangers().contains(client)) {
            return trip.toTripOutput();
        }if (trip.getPassangers().size() >= 20) {
            return trip.toTripOutput();
        }
        ticketOutput = new TicketOutput(client.getId(), trip.getId(), client.getName(), client.getFirstSurname(), client.getEmail(), trip.getOrigin(), trip.getDestination(), trip.getDepartureDate(), trip.getArrivalDate());
        ticketInterface.sendTicket(ticketOutput);
        trip.getPassangers().add(client);
        tripRepository.save(trip);
        return trip.toTripOutput();
    }

    @Override
    public TripOutput updateTripStatus(Integer tripId, String tripStatus) {
        Trip trip = tripRepository.findById(tripId).get();
        trip.setStatus(tripStatus);
        tripRepository.save(trip);
        return trip.toTripOutput();
    }

    @Override
    public Boolean verifyTrip(Integer tripId) {
        Trip trip = tripRepository.findById(tripId).get();
        if (trip.getStatus().equals("CANCELED")) {
            return false;
        }else if(trip.getStatus().equals("COMPLETED")) {
            return false;
        }else if(trip == null) {
            return false;
        }
        return trip.getPassangers().size() <= 20;
    }
}
