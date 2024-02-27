package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ProductoServiceImpl;
import org.example.dtos.input.ProductoInputDto;
import org.example.dtos.output.ProductoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Producto")
public class ControllerProducto {
    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping(value ="GetAllProductos")
    public Iterable<ProductoOutputDto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping(value = "/GetProducto/{idProducto}")
    public ProductoOutputDto getProducto(@PathVariable int idProducto) {
        return productoService.getProducto(idProducto);
    }

    @GetMapping(value = "/AddProducto")
    public ProductoOutputDto addProducto(@RequestBody ProductoInputDto producto) {
        return productoService.addProducto(producto);
    }

    @GetMapping(value = "/DeleteProducto")
    public void deleteProducto(int idProducto) {
        productoService.deleteProducto(idProducto);
    }

    @GetMapping(value = "/UpdateProducto/{idProducto}")
    public ProductoOutputDto updateProducto(int idProducto, ProductoInputDto producto) {
        return productoService.updateProducto(idProducto, producto);
    }

    @GetMapping(value = "/GetProductoName/{id}")
    public String getProductoName(@PathVariable int id) {
        return productoService.getProductoName(id);
    }
}
