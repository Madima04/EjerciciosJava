package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import jakarta.persistence.*;
import lombok.*;
import org.example.dtos.output.CabecerasDeFacturaOutputDtoSimple;
import org.example.dtos.output.ClienteOutputDto;
import org.example.dtos.output.ClienteOutputDtoSimple;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    int DNI;
    private String nombre;
    private String dirección;
    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;
    @OneToMany(mappedBy = "cliente")
    private Set<CabecerasDeFactura> cabecerasDeFacturas;


    public ClienteOutputDto toOutputDto() {
        ClienteOutputDto clienteOutputDto = new ClienteOutputDto();
        clienteOutputDto.setDNI(this.DNI);
        clienteOutputDto.setNombre(this.nombre);
        clienteOutputDto.setDirección(this.dirección);
        clienteOutputDto.setProvincia(this.provincia.toOutputDtoSimple());
        clienteOutputDto.setCabecerasDeFactura(getCabecerasDeFacturas(this.cabecerasDeFacturas.stream().map(CabecerasDeFactura::toOutputDto).collect(Collectors.toSet())));
        return clienteOutputDto;
    }

    private <R> Set<CabecerasDeFacturaOutputDtoSimple> getCabecerasDeFacturas(R collect) {
        Set<CabecerasDeFacturaOutputDtoSimple> cabecerasDeFacturaOutputDtoSimples = new HashSet<>();
        for (CabecerasDeFactura cabecera : cabecerasDeFacturas) {
            cabecerasDeFacturaOutputDtoSimples.add(cabecera.toOutputDtoSimple());
        }
        return cabecerasDeFacturaOutputDtoSimples;
    }

    public ClienteOutputDtoSimple toOutputDtoSimple() {
        ClienteOutputDtoSimple clienteOutputDto = new ClienteOutputDtoSimple();
        clienteOutputDto.setDNI(this.DNI);
        clienteOutputDto.setNombre(this.nombre);
        clienteOutputDto.setDirección(this.dirección);
        clienteOutputDto.setProvincia(this.provincia.toOutputDtoSimple());
        return clienteOutputDto;
    }
}
