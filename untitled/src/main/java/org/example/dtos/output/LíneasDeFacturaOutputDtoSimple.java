package org.example.dtos.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LíneasDeFacturaOutputDtoSimple {
    int idLínea;
    int idProducto;
    int cantidad;
    float precio;
    public void setProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdLínea() {
        return idLínea;
    }

}
