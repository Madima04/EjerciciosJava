package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabecerasDeFacturaOutputDto extends CabecerasDeFacturaOutputDtoSimple {
    int idCabecera;
    Date fecha;
    Float importeTotalFactura;
    ClienteOutputDtoSimple cliente;
    Set<LíneasDeFacturaOutputDto> líneasDeFactura;
}
