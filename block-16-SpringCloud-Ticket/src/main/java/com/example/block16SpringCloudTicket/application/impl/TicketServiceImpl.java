package com.example.block16SpringCloudTicket.application.impl;

import com.example.block16SpringCloudTicket.application.TicketService;
import com.example.block16SpringCloudTicket.domain.Ticket;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.TicketOutput;
import org.example.dto.output.TicketOutputSimple;
import org.example.dto.output.TripOutput;

public class TicketServiceImpl implements TicketService {
    @Override
    public TicketOutput addTicket(ClientOutput clientOutput, TripOutput tripOutput) {
        Ticket ticket = new Ticket();
        ticket.setPassengerId(clientOutput.getId());
        ticket.setTripId(tripOutput.getId());
        ticket.setPassengerName(clientOutput.getName());
        ticket.setPassengerSurname(clientOutput.getFirstSurname());
        ticket.setPassengerEmail(clientOutput.getEmail());
        ticket.setTripOrigin(tripOutput.getOrigin());
        ticket.setTripDestination(tripOutput.getDestination());
        ticket.setDepartureDate(tripOutput.getDepartureDate());
        ticket.setArrivalDate(tripOutput.getArrivalDate());
        return ticket.toTicketOutput();
    }

    @Override
    public TicketOutput getTicket(Integer id) {
        return null;
    }

    @Override
    public TicketOutput updateTicket(Integer id, ClientOutput clientOutput, TripOutput tripOutput) {
        return null;
    }

    @Override
    public boolean deleteTicket(Integer id) {
        return false;
    }

    @Override
    public Iterable<TicketOutputSimple> getTickets() {
        return null;
    }

    @Override
    public Integer getTicketCount(Integer tripId) {
        return null;
    }
}
