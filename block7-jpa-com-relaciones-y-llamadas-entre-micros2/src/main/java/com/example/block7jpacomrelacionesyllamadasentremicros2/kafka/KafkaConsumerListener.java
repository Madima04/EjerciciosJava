package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoProductos;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoVentas;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input.HistoricoVentasInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoClientesRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoProductosRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class KafkaConsumerListener {

    @Autowired
    HistoricoClientesRepository historicoClientesRepository;

    @Autowired
    HistoricoProductosRepository historicoProductosRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    private Map<String, Object> lastReceivedMessage;

    @KafkaListener(topics = {"Cliente"}, groupId = "group_id")
    public void listen(String message) {
        logger.info("Received Message in group foo: " + message);
        lastReceivedMessage = Collections.singletonMap("Cliente", message);
        HistoricoClientes historicoClientes = new HistoricoClientes();
        historicoClientes.setClienteId((Integer) lastReceivedMessage.get("idCliente"));
        historicoClientes.setNombre((String) lastReceivedMessage.get("nombreCliente"));
        if (historicoClientesRepository.findById(historicoClientes.getClienteId()).isPresent()) {
            historicoClientesRepository.deleteById(historicoClientes.getClienteId());
            historicoClientesRepository.save(historicoClientes);
        }else {
            historicoClientesRepository.save(historicoClientes);
        }
    }

    @KafkaListener(topics = {"Producto"}, groupId = "group_id")
    public void listenProducto(String message) {
        logger.info("Received Message in group foo: " + message);
        lastReceivedMessage = Collections.singletonMap("Producto", message);
        HistoricoProductos historicoProductos = new HistoricoProductos();
        historicoProductos.setProductoId((Integer) lastReceivedMessage.get("idProducto"));
        historicoProductos.setNombre((String) lastReceivedMessage.get("descripciónProducto"));
        if (historicoProductosRepository.findById(historicoProductos.getProductoId()).isPresent()) {
            historicoProductosRepository.deleteById(historicoProductos.getProductoId());
            historicoProductosRepository.save(historicoProductos);
        }else {
            historicoProductosRepository.save(historicoProductos);
        }
    }
}