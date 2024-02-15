package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
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

    public LíneasDeFactura ToLíneasDeFactura() {
        LíneasDeFactura líneasDeFactura = new LíneasDeFactura();
        líneasDeFactura.setIdLínea(this.idLínea);
        líneasDeFactura.setCantidad(this.cantidad);
        líneasDeFactura.setIdProducto(this.idProducto);
        líneasDeFactura.setPrecio(this.precio);
        return líneasDeFactura;
    }
}
