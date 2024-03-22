package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabecerasDeFacturaOutputDto extends CabecerasDeFacturaOutputDtoSimple {

    ClienteOutputDtoSimple cliente;
    Set<LíneasDeFacturaOutputDtoSimple> líneasDeFactura;
}
