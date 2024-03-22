package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.example.dtos.input.LíneasDeFacturaInputDto;

import java.util.Optional;

public class LíneasDeFacturaInputDtoEntity extends LíneasDeFacturaInputDto {
    public void setProducto(Optional<LíneasDeFactura> byId) {
        this.setIdProducto(byId.get().getProducto().getIdProducto());
    }
}
