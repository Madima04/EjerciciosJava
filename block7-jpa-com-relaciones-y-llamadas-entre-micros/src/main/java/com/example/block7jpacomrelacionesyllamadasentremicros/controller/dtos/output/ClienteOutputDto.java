package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Provincia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDto {
    int DNI;
    String nombre;
    String dirección;
    ProvinciaOutputDtoSimple provincia;
    Set<CabecerasDeFacturaOutputDtoSimple> cabecerasDeFactura;

    public ClienteOutputDtoSimple toOutputDtoSimple() {
        ClienteOutputDtoSimple clienteOutputDtoSimple = new ClienteOutputDtoSimple();
        clienteOutputDtoSimple.setDNI(this.DNI);
        clienteOutputDtoSimple.setNombre(this.nombre);
        clienteOutputDtoSimple.setDirección(this.dirección);
        return clienteOutputDtoSimple;
    }
}
