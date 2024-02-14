package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoOutputDtoSimple {
    int idProducto;
    String descripciónProducto;
    double precioProducto;
}
