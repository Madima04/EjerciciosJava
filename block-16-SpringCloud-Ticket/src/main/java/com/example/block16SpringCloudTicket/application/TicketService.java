package com.example.block16SpringCloudTicket.application;


import org.example.dto.output.ClientOutput;
import org.example.dto.output.TicketOutput;
import org.example.dto.output.TicketOutputSimple;
import org.example.dto.output.TripOutput;

public interface TicketService {
    TicketOutput addTicket(ClientOutput clientOutput, TripOutput tripOutput);

    TicketOutput getTicket(Integer id);

    TicketOutput updateTicket(Integer id, ClientOutput clientOutput, TripOutput tripOutput);

    boolean deleteTicket(Integer id);

    Iterable<TicketOutputSimple> getTickets();

    Integer getTicketCount(Integer tripId);
}
