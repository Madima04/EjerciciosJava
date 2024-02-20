package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.ProductoService;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ClienteServiceImpl;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ProductoServiceImpl;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ClienteInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProductoInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
