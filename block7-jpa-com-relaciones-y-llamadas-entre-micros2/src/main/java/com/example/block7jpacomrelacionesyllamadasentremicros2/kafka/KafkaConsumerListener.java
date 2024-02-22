package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoVentas;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input.HistoricoVentasInputDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class KafkaConsumerListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    private Map<String, Object> lastReceivedMessage;

    @KafkaListener(topics = {"factura"}, groupId = "group_id")
    public void listen(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            lastReceivedMessage = objectMapper.readValue(message, new TypeReference<Map<String, Object>>() {});
            HistoricoVentasInputDto historicoVentasInputDto = new HistoricoVentasInputDto();
            List<Object> listaLíneasDeFactura = (List<Object>) lastReceivedMessage.get("líneasDeFactura");
            List<Object> cliente = Collections.singletonList(lastReceivedMessage.get("cliente"));
            Map<String, Object> clienteMap = (Map<String, Object>) cliente.get(0);
            System.out.println("Cliente: " + clienteMap + " Líneas de factura: " + listaLíneasDeFactura);
            logger.info("Mensaje Kafka recibido: {}", lastReceivedMessage);
        } catch (JsonProcessingException e) {
            logger.error("Error al procesar el mensaje Kafka: {}", e.getMessage());
        }
    }
}