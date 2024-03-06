package com.example.block16springcloud.controller;

import com.example.block16springcloud.application.ClientService;
import org.example.dto.input.ClientInput;
import org.example.dto.output.ClientOutput;
import org.example.dto.output.ClientOutputSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-service")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/add-client")
    public ResponseEntity<ClientOutput> addClient(@RequestBody ClientInput clientInput) {
        return ResponseEntity.ok(clientService.addClient(clientInput));
    }
    @GetMapping("/get-clients")
    public ResponseEntity<Iterable<ClientOutputSimple>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }
    @GetMapping("/get-client/{id}")
    public ResponseEntity<ClientOutput> getClient(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }
    @GetMapping("/update-client/{id}")
    public ResponseEntity<ClientOutput> updateClient(@PathVariable Integer id, @RequestBody ClientInput clientInput) {
        return ResponseEntity.ok(clientService.updateClient(id, clientInput));
    }
    @GetMapping("/delete-client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-client/count/{tripId}")
    public ResponseEntity<Integer> getClientCount(@PathVariable Integer tripId) {
        return ResponseEntity.ok(clientService.getClientCount(tripId));
    }
}
