package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ClienteInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDtoSimple;

public interface ClienteService {
    ClienteOutputDto getClienteById(Long id);
    ClienteOutputDtoSimple addCliente(ClienteInputDto clienteInputDto);
    void deleteCliente(Long id);
    ClienteOutputDto updateCliente(ClienteInputDto clienteInputDto, Long id);
    Iterable<ClienteOutputDto> getAllClientes();
}
