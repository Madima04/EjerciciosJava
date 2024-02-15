package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1, message = "La cantidad debe ser mayor que 0")
    int cantidad;
    @Min(value = 0, message = "El precio debe ser mayor o igual que 0")
    float precio;
    @Min(value = 0, message = "El importe debe ser mayor o igual que 0")
    float importe;

    public Object getIdLíneaDeFactura() {
        return idLínea;
    }

    public void setProducto(Optional<LíneasDeFactura> byId) {
        this.idProducto = byId.get().getProducto().getIdProducto();
    }
}
