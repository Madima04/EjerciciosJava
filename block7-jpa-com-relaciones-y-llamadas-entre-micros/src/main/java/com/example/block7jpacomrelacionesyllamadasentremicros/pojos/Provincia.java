package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvincia;
    private String nombreProvincia;
    @OneToMany(mappedBy = "provincia")
    private Set<Cliente> clientes;

    public ProvinciaOutputDto toOutputDto() {
        ProvinciaOutputDto provinciaOutputDto = new ProvinciaOutputDto();
        provinciaOutputDto.setIdProvincia(this.idProvincia);
        provinciaOutputDto.setNombreProvincia(this.nombreProvincia);
        provinciaOutputDto.setClientes(convertirListaClientes(this.clientes));
        return provinciaOutputDto;
    }

    private Set<ClienteOutputDtoSimple> convertirListaClientes(Set<Cliente> clientes) {
        return clientes.stream()
                .map(this::convertirCliente)
                .collect(Collectors.toSet());
    }

    private ClienteOutputDtoSimple convertirCliente(Cliente cliente) {

        return new ClienteOutputDtoSimple(cliente);
    }

    public ProvinciaOutputDtoSimple toOutputDtoSimple() {
        ProvinciaOutputDtoSimple provinciaOutputDtoSimple = new ProvinciaOutputDtoSimple();
        provinciaOutputDtoSimple.setIdProvincia(this.idProvincia);
        provinciaOutputDtoSimple.setNombreProvincia(this.nombreProvincia);
        provinciaOutputDtoSimple.setClientes(convertirListaClientes(this.clientes));
        return provinciaOutputDtoSimple;
    }

    public ProvinciaOutputDtoImp toOutputDtoImp() {
        ProvinciaOutputDtoImp provinciaOutputDtoSimple = new ProvinciaOutputDtoImp();
        provinciaOutputDtoSimple.setIdProvincia(this.idProvincia);
        provinciaOutputDtoSimple.setNombreProvincia(this.nombreProvincia);
        return provinciaOutputDtoSimple;
    }

}

