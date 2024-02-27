package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabecerasDeFacturaOutputDtoSimple {
    int idCabecera;
    Date fecha;
    Float importeTotalFactura;
}
