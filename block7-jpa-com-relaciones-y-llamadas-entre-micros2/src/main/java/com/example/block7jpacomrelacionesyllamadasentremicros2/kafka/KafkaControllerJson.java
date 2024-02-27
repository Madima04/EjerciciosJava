package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.ClienteOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
public class KafkaControllerJson {
    @Autowired
    private KafkaTemplate<String, ClienteOutputDtoSimple> kafkaTemplateCliente;
    @Autowired
    MessageKafka messageKafka;

    @PostMapping("/json/{topic}/{key}")
    public MessageKafka  sendJson(@RequestBody ClienteOutputDtoSimple clienteOutputDtoSimple, @PathVariable String topic, @PathVariable String key){
        messageKafka.setClienteOutputDtoSimple(clienteOutputDtoSimple);
        messageKafka.setKey(key);
        messageKafka.setTopic(topic);
        messageKafka.setTimeStamp(new Date());
        kafkaTemplateCliente.send(topic, key, clienteOutputDtoSimple);
        messageKafka.setReceived(true);
        return messageKafka;
    }

    private void waitMessage() throws InterruptedException
    {
        long initialDate=System.currentTimeMillis();
        long finalDate=initialDate+1000*10; // Add 10 seconds
        while (!messageKafka.isReceived() && finalDate>System.currentTimeMillis())
        {
            Thread.currentThread().sleep(500);
        }
    }

}
