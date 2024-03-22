package com.example.block16springcloud.application.impl;

import com.example.block16springcloud.application.ClientService;
import com.example.block16springcloud.domain.Client;
import com.example.block16springcloud.domain.Trip;
import com.example.block16springcloud.repository.ClientRepository;
import com.example.block16springcloud.repository.TripRepository;
import org.example.dto.input.ClientInput;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.ClientOutputSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TripRepository tripRepository;

    @Override
    public ClientOutput addClient(ClientInput clientInput) {
        Client client = new Client();
        client.setName(clientInput.getName());
        client.setFirstSurname(clientInput.getFirstSurname());
        client.setAge(clientInput.getAge());
        client.setEmail(clientInput.getEmail());
        client.setPhone(clientInput.getPhone());
        clientRepository.save(client);
        return client.toClientOutput();
    }

    @Override
    public ClientOutput getClient(Integer id) {
        return clientRepository.findById(id).get().toClientOutput();
    }

    @Override
    public ClientOutput updateClient(Integer id, ClientInput clientInput) {
        return null;
    }

    @Override
    public boolean deleteClient(Integer id) {
        return false;
    }

    @Override
    public Iterable<ClientOutputSimple> getClients() {
        return null;
    }

    @Override
    public Integer getClientCount(Integer tripId) {
        Trip trip = tripRepository.findById(tripId).get();
        return ClientRepository.findByTrip(trip).size();
    }
}
