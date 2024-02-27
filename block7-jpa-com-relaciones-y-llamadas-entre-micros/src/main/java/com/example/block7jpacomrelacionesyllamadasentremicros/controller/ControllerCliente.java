package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ClienteServiceImpl;
import org.example.dtos.input.ClienteInputDto;
import org.example.dtos.output.ClienteOutputDto;
import org.example.dtos.output.ClienteOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ControllerCliente {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping(value ="/GetAllClientes")
    public Iterable<ClienteOutputDto> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping(value = "/GetCliente/{id}")
    public ClienteOutputDto getCliente(Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping(value = "/addCliente")
    public ClienteOutputDtoSimple addCliente(@RequestBody ClienteInputDto cliente) {
        return clienteService.addCliente(cliente);
    }

    @GetMapping(value = "/GetNombreCliente/{id}")
    public String getNombreCliente(@PathVariable long id) {
        return clienteService.getNombreCliente(id);
    }

    @GetMapping(value = "/DeleteCliente/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping(value = "/UpdateCliente")
    public ClienteOutputDto updateCliente(ClienteInputDto cliente, Long id) {
        return clienteService.updateCliente(cliente, id);
    }
}
