package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import org.example.dtos.input.ClienteInputDto;
import org.example.dtos.output.ClienteOutputDto;
import org.example.dtos.output.ClienteOutputDtoSimple;

public interface ClienteService {
    ClienteOutputDto getClienteById(Long id);
    ClienteOutputDtoSimple addCliente(ClienteInputDto clienteInputDto);
    void deleteCliente(Long id);
    ClienteOutputDto updateCliente(ClienteInputDto clienteInputDto, Long id);
    Iterable<ClienteOutputDto> getAllClientes();
}
