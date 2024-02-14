package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInputDto {
    int DNI;
    int provinciaId;
    String nombre;
    String dirección;
    Set<Integer> cabecerasDeFacturas;

}
