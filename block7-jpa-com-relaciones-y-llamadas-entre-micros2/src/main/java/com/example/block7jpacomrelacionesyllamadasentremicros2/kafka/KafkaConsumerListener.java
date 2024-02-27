package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoProductos;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoClientesRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoProductosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dtos.output.ClienteOutputDtoSimple;
import org.example.dtos.output.ProductoOutputDtoSimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaConsumerListener {

    @Autowired
    HistoricoClientesRepository historicoClientesRepository;

    @Autowired
    HistoricoProductosRepository historicoProductosRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "Cliente", groupId = "group_id")
    public void listen(ClienteOutputDtoSimple clienteJson) {
        logger.info("Received Message in group foo: " + clienteJson);
        ObjectMapper objectMapper = new ObjectMapper();
        HistoricoClientes historicoClientes = new HistoricoClientes();
        historicoClientes.setClienteId(clienteJson.getDNI());
        historicoClientes.setNombre(clienteJson.getNombre());
        if (historicoClientesRepository.findById(clienteJson.getDNI()).isPresent()) {
            historicoClientesRepository.deleteById(clienteJson.getDNI());
        }
        historicoClientesRepository.save(historicoClientes);
    }

    @KafkaListener(topics = "Producto", groupId = "group_id")
    public void listenProducto(ProductoOutputDtoSimple producto) {
        logger.info("Received Message in group foo: " + producto);
        HistoricoProductos historicoProductos = new HistoricoProductos();
        historicoProductos.setIdProducto(producto.getIdProducto());
        historicoProductos.setDescripciónProducto(producto.getDescripciónProducto());
        if (historicoProductosRepository.findById(producto.getIdProducto()).isPresent()) {
            historicoProductosRepository.deleteById(producto.getIdProducto());
        }
        historicoProductosRepository.save(historicoProductos);
    }
}