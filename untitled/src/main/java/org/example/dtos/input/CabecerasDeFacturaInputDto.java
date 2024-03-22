package org.example.dtos.input;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dtos.output.LíneasDeFacturaOutputDtoSimple;

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
