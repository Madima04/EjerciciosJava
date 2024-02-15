package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInputDto {
    @Digits(integer = 8, fraction = 0, message = "El DNI debe tener 8 dígitos")
    int DNI;
    int provinciaId;
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El nombre no puede contener caracteres especiales")
    String nombre;
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "La dirección no puede contener caracteres especiales")
    String dirección;
    Set<Integer> cabecerasDeFacturas;

}
