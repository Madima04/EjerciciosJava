package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class LíneasDeFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLínea;
    private int cantidad;
    private float precio;
    private float importe;
    @ManyToOne
    @JoinColumn(name = "idCabecera")
    private CabecerasDeFactura cabecerasDeFactura;
    @OneToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    private Producto producto;
    public LíneasDeFacturaOutputDto toOutputDto() {
        LíneasDeFacturaOutputDto líneasDeFacturaOutputDto = new LíneasDeFacturaOutputDto();
        líneasDeFacturaOutputDto.setIdLínea(this.idLínea);
        líneasDeFacturaOutputDto.setCantidad(this.cantidad);
        líneasDeFacturaOutputDto.setPrecio(this.precio);
        líneasDeFacturaOutputDto.setImporte(this.importe);
        líneasDeFacturaOutputDto.setCabecerasDeFactura(this.cabecerasDeFactura.toOutputDto());
        líneasDeFacturaOutputDto.setProducto(this.producto.toOutputDto());
        return líneasDeFacturaOutputDto;
    }
    public void setCabecera(CabecerasDeFactura cabecerasDeFactura) {
        this.cabecerasDeFactura = cabecerasDeFactura;
    }

    public void setIdProducto(int idProducto) {
        this.producto.setIdProducto(idProducto);
    }

    public LíneasDeFacturaOutputDtoSimple toOutputDtoSimple() {
        LíneasDeFacturaOutputDtoSimple líneasDeFacturaOutputDto = new LíneasDeFacturaOutputDtoSimple();
        líneasDeFacturaOutputDto.setIdLínea(this.idLínea);
        líneasDeFacturaOutputDto.setCantidad(this.cantidad);
        líneasDeFacturaOutputDto.setPrecio(this.precio);
        return líneasDeFacturaOutputDto;
    }

}
