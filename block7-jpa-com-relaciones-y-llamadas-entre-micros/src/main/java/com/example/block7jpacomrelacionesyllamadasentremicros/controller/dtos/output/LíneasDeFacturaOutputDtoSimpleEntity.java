package com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.example.dtos.output.LíneasDeFacturaOutputDtoSimple;

public class LíneasDeFacturaOutputDtoSimpleEntity extends LíneasDeFacturaOutputDtoSimple {
    public LíneasDeFactura ToLíneasDeFactura() {
        LíneasDeFactura líneasDeFactura = new LíneasDeFactura();
        líneasDeFactura.setIdLínea(this.getIdLínea());
        líneasDeFactura.setCantidad(this.getCantidad());
        líneasDeFactura.setIdProducto(this.getIdProducto());
        líneasDeFactura.setPrecio(this.getPrecio());
        return líneasDeFactura;
    }
}
