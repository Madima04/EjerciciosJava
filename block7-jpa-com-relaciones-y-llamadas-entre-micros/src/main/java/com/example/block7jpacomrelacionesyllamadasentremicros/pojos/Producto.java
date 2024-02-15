package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProductoInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDtoSimple;
import jakarta.persistence.*;
import lombok.*;

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
