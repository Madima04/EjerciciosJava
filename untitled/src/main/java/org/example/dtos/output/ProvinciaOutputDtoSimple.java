package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaOutputDtoSimple {
    int idProvincia;
    String nombreProvincia;
    Set<ClienteOutputDtoSimple> clientes;


}
