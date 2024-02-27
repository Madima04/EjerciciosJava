package com.example.block7jpacomrelacionesyllamadasentremicros.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.dtos.output.ClienteOutputDtoSimple;
import org.example.dtos.output.ProductoOutputDtoSimple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
@EnableKafka
@Configuration
public class KafkaProviderConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boootstrapServers;

    public Map<String, Object> producerConfig(){
        Map<String,Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, true);
        return properties;
    }

    @Bean
    public ProducerFactory<String, ClienteOutputDtoSimple> producerFactoryCliente() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ClienteOutputDtoSimple> kafkaTemplateCliente() {
        return new KafkaTemplate<>(producerFactoryCliente());
    }

    @Bean
    public ProducerFactory<String, ProductoOutputDtoSimple> producerFactoryProducto() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ProductoOutputDtoSimple> kafkaTemplateProducto() {
        return new KafkaTemplate<>(producerFactoryProducto());
    }

}