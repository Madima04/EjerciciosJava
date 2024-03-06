package com.example.block16springcloud.repository;

import com.example.block16springcloud.domain.Client;
import com.example.block16springcloud.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    static List<Client> findByTrip(Trip trip) {
        List<Client> clients = new ArrayList<>();
        for (Client client : trip.getPassangers()) {
            clients.add(client);
        }
        return clients;
    }
}
