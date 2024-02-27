package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.CabecerasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.LíneasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProductoRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.ProductoService;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProductoInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ClienteOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProductoOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    LíneasDeFacturaRepository líneasDeFacturaRepository;
    @Autowired
    CabecerasDeFacturaRepository cabecerasDeFacturaRepository;
    @Autowired
    KafkaTemplate<String, ProductoOutputDtoSimple> kafkaTemplate;

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
        //producto.setLineasDeFacturas((LíneasDeFactura) líneasDeFacturaRepository.findAllById(productoInputDto.getLíneasDeFactura()));
        productoRepository.save(producto).toOutputDto();
        kafkaTemplate.send("Producto", producto.toOutputDtoSimple());
        return producto.toOutputDto();
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
        kafkaTemplate.send("Producto", producto.toOutputDtoSimple());
        return productoRepository.save(producto).toOutputDto();
    }

    @Override
    public Iterable<ProductoOutputDto> getAllProductos() {
        return productoRepository.findAll().stream().map(Producto::toOutputDto).toList();
    }

    public ProductoOutputDtoSimple getProductoByName(String name) {
        return productoRepository.findByDescripciónProducto(name).toOutputDtoSimple();
    }

    public ProductoOutputDtoSimple getProductoDescription(int idProducto) {
        return productoRepository.findById(idProducto).get().toOutputDtoSimple();
    }

    public String getProductoName(int id) {
        return productoRepository.findById(id).get().getDescripciónProducto();
    }
}
