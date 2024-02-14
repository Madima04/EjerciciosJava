package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LíneasDeFacturaOutputDto {
    int idLínea;
    int cantidad;
    float precio;
    float importe;
    ProductoOutputDto producto;
    CabecerasDeFacturaOutputDto cabecerasDeFactura;
}
