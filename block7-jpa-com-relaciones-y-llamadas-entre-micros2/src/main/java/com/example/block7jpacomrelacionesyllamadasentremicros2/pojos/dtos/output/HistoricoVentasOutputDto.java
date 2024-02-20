package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoVentasOutputDto {
    int id;
    int clienteId;
    int productoId;
    int mes;
    int año;
    int cantidad;
    double importe;
}
