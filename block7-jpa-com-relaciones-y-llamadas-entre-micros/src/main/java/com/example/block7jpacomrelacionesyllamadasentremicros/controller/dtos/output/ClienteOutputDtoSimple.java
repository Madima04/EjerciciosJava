package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDtoSimple {
    int DNI;
    String nombre;
    String dirección;


    public ClienteOutputDtoSimple(Cliente cliente) {
        this.DNI = cliente.getDNI();
        this.nombre = cliente.getNombre();
        this.dirección = cliente.getDirección();
    }

    public void setProvincia(ProvinciaOutputDtoSimple outputDtoSimple) {
    }
}
