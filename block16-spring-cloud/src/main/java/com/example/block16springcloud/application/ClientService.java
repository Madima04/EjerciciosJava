package com.example.block16springcloud.application;

import org.example.dto.input.ClientInput;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.ClientOutputSimple;
import org.springframework.data.jpa.repository.Query;

public interface ClientService {
    ClientOutput addClient(ClientInput clientInput);

    ClientOutput getClient(Integer id);

    ClientOutput updateClient(Integer id, ClientInput clientInput);

    boolean deleteClient(Integer id);

    Iterable<ClientOutputSimple> getClients();

    Integer getClientCount(Integer tripId);
}
