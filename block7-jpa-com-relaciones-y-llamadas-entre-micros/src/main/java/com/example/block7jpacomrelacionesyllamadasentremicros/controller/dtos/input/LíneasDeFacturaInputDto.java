package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
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

    public void setProducto(Optional<LíneasDeFactura> byId) {
        this.idProducto = byId.get().getProducto().getIdProducto();
    }
}
