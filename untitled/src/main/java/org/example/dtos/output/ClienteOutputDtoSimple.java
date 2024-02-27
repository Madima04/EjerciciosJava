package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDtoSimple {
    int DNI;
    String nombre;
    String dirección;
    public void setProvincia(ProvinciaOutputDtoSimple outputDtoSimple) {
    }
}
