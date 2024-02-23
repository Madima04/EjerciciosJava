package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoProductosInput {
    int productoId;
    String nombre;
}
