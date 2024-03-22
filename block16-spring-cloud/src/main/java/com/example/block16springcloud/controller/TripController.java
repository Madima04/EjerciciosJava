package com.example.block16springcloud.controller;

import com.example.block16springcloud.application.TripService;
import com.example.block16springcloud.configuration.rabbitMQ.publisher.RabbitMQProducer;
import com.example.block16springcloud.repository.TripRepository;
import org.example.dto.input.TripInput;
import org.example.dto.output.TripOutput;
import org.example.dto.output.TripOutputSimple;
import org.example.dto.output.TripSimplifyOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/trip-service")
public class TripController {
    private final TripService tripService;
    @Autowired
    RabbitMQProducer rabbitMQProducer;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/trips")
    public ResponseEntity<TripOutputSimple> addTrip(@RequestBody TripInput tripInput) {
        return new ResponseEntity<>(tripService.addTrip(tripInput), HttpStatus.CREATED);
    }

    @GetMapping("/trips")
    public ResponseEntity<Iterable<TripOutputSimple>> getTrips() {
        return new ResponseEntity<>(tripService.getTrips(), HttpStatus.OK);
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<TripOutput> getTrip(@PathVariable Integer id) {
        return new ResponseEntity<>(tripService.getTrip(id), HttpStatus.OK);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<TripOutput> updateTrip(@PathVariable Integer id, @RequestBody TripInput tripInput) {
        return new ResponseEntity<>(tripService.updateTrip(id, tripInput), HttpStatus.OK);
    }

    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Integer id) {
        if (tripService.deleteTrip(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/trips/{id}/clients/{clientId}")
    public ResponseEntity<TripOutput> addClientToTrip(@PathVariable Integer id, @PathVariable Integer clientId) {
        return new ResponseEntity<>(tripService.addClientToTrip(id, clientId), HttpStatus.OK);
    }

    @PutMapping("/trips/{tripId}/{tripStatus}")
    public ResponseEntity<TripOutput> updateTripStatus(@PathVariable Integer tripId, @PathVariable String tripStatus) {
        return new ResponseEntity<>(tripService.updateTripStatus(tripId, tripStatus), HttpStatus.OK);
    }

    @GetMapping("/trips/verify/{tripId}")
    public ResponseEntity<Boolean> verifyTrip(@PathVariable Integer tripId) {
        return new ResponseEntity<>(tripService.verifyTrip(tripId), HttpStatus.OK);
    }

    @PostMapping("/receiveTrip")
    public ResponseEntity<Void> receiveTicket(@RequestBody TripSimplifyOutput ticket) {
        rabbitMQProducer.sendMessage(tripService.saveTrip(ticket));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
