package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInputDto {
    int idProducto;
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "La descripción no puede contener caracteres especiales")
    String descripciónProducto;
    @Min(value = 0, message = "El precio debe ser mayor o igual que 0")
    double precioProducto;
    Set<Integer> líneasDeFactura;

}
