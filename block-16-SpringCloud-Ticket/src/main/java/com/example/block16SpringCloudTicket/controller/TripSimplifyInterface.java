package com.example.block16SpringCloudTicket.controller;

import org.example.dto.output.TripSimplifyOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "block16-cloud-trip")
public interface TripSimplifyInterface {
    @PostMapping("/trip-service/receiveTrip")
    TripSimplifyOutput sendTicket(@RequestBody TripSimplifyOutput ticket);
}
