package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaInputDto {
    int idProvincia;
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El nombre no puede contener caracteres especiales")
    String nombreProvincia;
}
