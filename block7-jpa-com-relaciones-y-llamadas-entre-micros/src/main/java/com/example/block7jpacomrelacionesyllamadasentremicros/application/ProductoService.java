package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import org.example.dtos.input.ProductoInputDto;
import org.example.dtos.output.ProductoOutputDto;

public interface ProductoService {
    ProductoOutputDto getProducto(int idProducto);
    ProductoOutputDto updateProducto(int idProducto, ProductoInputDto productoInputDto);
    void deleteProducto(int idProducto);
    ProductoOutputDto addProducto(ProductoInputDto productoInputDto);
    Iterable<ProductoOutputDto> getAllProductos();

}
