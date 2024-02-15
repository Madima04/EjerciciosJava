package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
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
    int DNI;
    Date fecha;
    Set<LíneasDeFacturaOutputDtoSimple> líneasDeFactura;
}
