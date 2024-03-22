package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOutputDto {
    int DNI;
    String nombre;
    String dirección;
    ProvinciaOutputDtoSimple provincia;
    Set<CabecerasDeFacturaOutputDtoSimple> cabecerasDeFactura;

    public ClienteOutputDtoSimple toOutputDtoSimple() {
        ClienteOutputDtoSimple clienteOutputDtoSimple = new ClienteOutputDtoSimple();
        clienteOutputDtoSimple.setDNI(this.DNI);
        clienteOutputDtoSimple.setNombre(this.nombre);
        clienteOutputDtoSimple.setDirección(this.dirección);
        return clienteOutputDtoSimple;
    }
}
