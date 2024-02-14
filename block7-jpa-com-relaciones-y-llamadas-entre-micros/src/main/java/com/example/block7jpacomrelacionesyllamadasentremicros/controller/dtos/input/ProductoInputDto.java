package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInputDto {
    int idProducto;
    String descripciónProducto;
    double precioProducto;
    Set<Integer> líneasDeFactura;

}
