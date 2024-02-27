package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDtoSimple {
    int DNI;
    String nombre;
    String dirección;
}
