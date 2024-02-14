package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaOutputDtoImp {
    int idProvincia;
    String nombreProvincia;
    public void setClientes(Set<ClienteOutputDtoSimple> clienteOutputDtoSimples) {
    }
}
