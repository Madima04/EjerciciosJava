package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"factura"}, groupId = "group_id")
    public void listen(String message) {
        logger.info("Mensaje recibido: " + message);
    }
}
