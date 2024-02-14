package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.LíneasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProductoInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ProductoService {
    ProductoOutputDto getProducto(int idProducto);
    ProductoOutputDto updateProducto(int idProducto, ProductoInputDto productoInputDto);
    void deleteProducto(int idProducto);
    ProductoOutputDto addProducto(ProductoInputDto productoInputDto);
    Iterable<ProductoOutputDto> getAllProductos();

}
