package com.example.block16SpringCloudTicket.controller;

import com.example.block16SpringCloudTicket.application.TripSimplifyService;
import org.example.dto.output.TripSimplifyOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tpv")
public class TripSimplifyController {
    @Autowired
    TripSimplifyInterface tripSimplifyInterface;
    @Autowired
    TripSimplifyService tripSimplifyService;
    @PutMapping("/buyTicket")
    public TripSimplifyOutput sendTicket(@RequestParam int idTrip, @RequestParam int cantidad) {
        return tripSimplifyInterface.sendTicket(tripSimplifyService.comparTicket(idTrip, cantidad));
    }
}
