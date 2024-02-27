package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import org.example.dtos.output.ClienteOutputDtoSimple;

public class ClienteOutputDtoSimpleEntity extends ClienteOutputDtoSimple {
    public ClienteOutputDtoSimpleEntity(Cliente cliente) {
        this.setDNI(cliente.getDNI());
        this.setNombre(cliente.getNombre());
        this.setDirección(cliente.getDirección());
    }
}
