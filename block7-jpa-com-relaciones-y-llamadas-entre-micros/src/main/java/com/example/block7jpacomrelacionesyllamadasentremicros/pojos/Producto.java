package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import jakarta.persistence.*;
import lombok.*;
import org.example.dtos.output.ProductoOutputDto;
import org.example.dtos.output.ProductoOutputDtoSimple;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String descripciónProducto;
    private double precioProducto;
    @OneToOne(mappedBy = "producto")
    private LíneasDeFactura lineasDeFacturas;

    public ProductoOutputDto toOutputDto() {
        ProductoOutputDto productoOutputDto = new ProductoOutputDto();
        productoOutputDto.setIdProducto(this.idProducto);
        productoOutputDto.setDescripciónProducto(this.descripciónProducto);
        productoOutputDto.setPrecioProducto(this.precioProducto);
        //productoOutputDto.setLíneasDeFacturas(this.lineasDeFacturas.toOutputDto());
        return productoOutputDto;
    }

    public float getPrecio() {
        return (float) this.precioProducto;
    }

    public ProductoOutputDtoSimple toOutputDtoSimple() {
        ProductoOutputDtoSimple productoOutputDtoSimple = new ProductoOutputDtoSimple();
        productoOutputDtoSimple.setIdProducto(this.idProducto);
        productoOutputDtoSimple.setDescripciónProducto(this.descripciónProducto);
        productoOutputDtoSimple.setPrecioProducto(this.getPrecio());
        return productoOutputDtoSimple;
    }
}
