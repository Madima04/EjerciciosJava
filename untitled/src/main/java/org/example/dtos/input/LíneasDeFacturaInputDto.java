package org.example.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LíneasDeFacturaInputDto {
    int idLínea;
    int idProducto;
    int idCabecera;
    int cantidad;
    float precio;
    float importe;

    public Object getIdLíneaDeFactura() {
        return idLínea;
    }
}
