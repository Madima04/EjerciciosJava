package com.example.block7jpacomrelacionesyllamadasentremicros2.kafka;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.ClienteOutputDtoSimple;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageKafka
{
    ClienteOutputDtoSimple clienteOutputDtoSimple;
    String message;
    String key;
    Date timeStamp;
    int partition;
    String topic;
    boolean received=false;
}
