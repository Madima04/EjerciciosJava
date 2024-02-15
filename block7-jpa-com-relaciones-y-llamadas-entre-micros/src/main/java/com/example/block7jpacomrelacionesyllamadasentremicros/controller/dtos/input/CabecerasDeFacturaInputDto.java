package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabecerasDeFacturaInputDto {
    int idCabecera;
    @Digits(integer = 8, fraction = 0, message = "El DNI debe tener 8 dígitos")
    int DNI;
    @Future(message = "La fecha debe ser futura")
    Date fecha;
    Set<LíneasDeFacturaOutputDtoSimple> líneasDeFactura;
}
