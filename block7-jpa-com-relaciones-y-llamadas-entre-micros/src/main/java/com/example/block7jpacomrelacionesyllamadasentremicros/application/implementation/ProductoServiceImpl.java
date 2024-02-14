package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.CabecerasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.LíneasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProductoRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.ProductoService;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.LíneasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProductoInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    LíneasDeFacturaRepository líneasDeFacturaRepository;
    @Autowired
    CabecerasDeFacturaRepository cabecerasDeFacturaRepository;

    @Override
    public ProductoOutputDto getProducto(int idProducto) {
        return productoRepository.findById(idProducto).get().toOutputDto();
    }

    @Override
    public ProductoOutputDto updateProducto(int idProducto, ProductoInputDto productoInputDto) {
        Producto producto = new Producto();
        producto.setIdProducto(productoInputDto.getIdProducto());
        producto.setDescripciónProducto(productoInputDto.getDescripciónProducto());
        producto.setPrecioProducto(productoInputDto.getPrecioProducto());
        producto.setLineasDeFacturas((LíneasDeFactura) líneasDeFacturaRepository.findAllById(productoInputDto.getLíneasDeFactura()));
        return productoRepository.save(producto).toOutputDto();
    }

    @Override
    public void deleteProducto(int idProducto) {
        productoRepository.findById(idProducto).ifPresent(productoRepository::delete);
    }

    @Override
    public ProductoOutputDto addProducto(ProductoInputDto productoInputDto) {
        Producto producto = new Producto();
        producto.setIdProducto(productoInputDto.getIdProducto());
        producto.setDescripciónProducto(productoInputDto.getDescripciónProducto());
        producto.setPrecioProducto(productoInputDto.getPrecioProducto());
        //producto.setLineasDeFacturas((LíneasDeFactura) líneasDeFacturaRepository.findAllById(productoInputDto.getLíneasDeFactura()));
        return productoRepository.save(producto).toOutputDto();
    }

    @Override
    public Iterable<ProductoOutputDto> getAllProductos() {
        return productoRepository.findAll().stream().map(Producto::toOutputDto).toList();
    }
}
