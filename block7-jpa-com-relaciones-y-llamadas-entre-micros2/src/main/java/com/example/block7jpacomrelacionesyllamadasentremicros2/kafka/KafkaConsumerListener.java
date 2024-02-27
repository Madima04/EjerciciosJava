package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoProductos;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.ClienteOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.ProductoOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoClientesRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoProductosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void listen(String clienteJson) {
        logger.info("Received Message in group foo: " + clienteJson);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClienteOutputDtoSimple cliente = objectMapper.readValue(clienteJson, ClienteOutputDtoSimple.class);
            HistoricoClientes historicoClientes = new HistoricoClientes();
            historicoClientes.setClienteId(cliente.getDNI());
            historicoClientes.setNombre(cliente.getNombre());
            if (historicoClientesRepository.findById(historicoClientes.getClienteId()).isPresent()) {
                historicoClientesRepository.deleteById(historicoClientes.getClienteId());
            }
            historicoClientesRepository.save(historicoClientes);
        } catch (IOException e) {
            logger.error("Error al deserializar el JSON: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "Producto", groupId = "group_id")
    public void listenProducto(String producto) {
        logger.info("Received Message in group foo: " + producto);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HistoricoProductos historicoProductos = objectMapper.readValue(producto.toString(), HistoricoProductos.class);
            historicoProductos.setIdProducto(historicoProductos.getIdProducto());
            historicoProductos.setDescripciónProducto(historicoProductos.getDescripciónProducto());
            if (historicoProductosRepository.findById(historicoProductos.getIdProducto()).isPresent()) {
                historicoProductosRepository.deleteById(historicoProductos.getIdProducto());
            }
            historicoProductosRepository.save(historicoProductos);
        } catch (Exception e) {
            logger.error("Error al deserializar el JSON: " + e.getMessage());
        }
    }
}