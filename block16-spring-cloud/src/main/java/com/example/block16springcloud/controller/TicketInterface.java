package com.example.block16springcloud.controller;

import org.example.dto.output.TicketOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "block16-cloud-ticket")
public interface TicketInterface {
    @PostMapping("/api/receiveTicket")
    TicketOutput sendTicket(@RequestBody TicketOutput ticket);
}
