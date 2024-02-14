package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ClienteServiceImpl;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ClienteInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDtoSimple;
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

    @GetMapping(value = "/DeleteCliente/{id}")
    public void deleteCliente(Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping(value = "/UpdateCliente")
    public ClienteOutputDto updateCliente(ClienteInputDto cliente, Long id) {
        return clienteService.updateCliente(cliente, id);
    }
}
