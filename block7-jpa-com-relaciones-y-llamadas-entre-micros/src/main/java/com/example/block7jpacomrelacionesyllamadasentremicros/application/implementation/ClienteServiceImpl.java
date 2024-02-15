package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.CabecerasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ClienteRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProvinciaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.ClienteService;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ClienteInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CabecerasDeFacturaRepository cabecerasDeFacturaRepository;
    @Autowired
    ProvinciaRepository provinciaRepository;

    @Override
    public ClienteOutputDto getClienteById(Long id) {
        ClienteOutputDto clienteOutputDto = new ClienteOutputDto();
        clienteRepository.findById(Math.toIntExact(id));
        return clienteOutputDto;
    }

    @Override
    public ClienteOutputDtoSimple addCliente(ClienteInputDto clienteInputDto) {
        Cliente cliente = new Cliente();
        cliente.setDNI(clienteInputDto.getDNI());
        cliente.setNombre(clienteInputDto.getNombre());
        cliente.setDirección(clienteInputDto.getDirección());
        Optional<Provincia> provincia = provinciaRepository.findById(clienteInputDto.getProvinciaId());
        provincia.ifPresent(cliente::setProvincia);
        clienteRepository.save(cliente);
        return cliente.toOutputDtoSimple();
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.findById(Math.toIntExact(id)).ifPresent(clienteRepository::delete);
    }

    @Override
    public ClienteOutputDto updateCliente(ClienteInputDto clienteInputDto, Long id) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(id)).get();
        cliente.setDNI(clienteInputDto.getDNI());
        cliente.setNombre(clienteInputDto.getNombre());
        cliente.setDirección(clienteInputDto.getDirección());
        cliente.setProvincia(provinciaRepository.findById(clienteInputDto.getProvinciaId()).get());
        clienteRepository.save(cliente);
        return cliente.toOutputDto();
    }

    @Override
    public Iterable<ClienteOutputDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(Cliente::toOutputDto).toList();
    }

    public ClienteOutputDtoSimple getClienteByNombre(String nombre) {
        Cliente cliente = clienteRepository.findByNombre(nombre);
        return cliente.toOutputDtoSimple();
    }
}
