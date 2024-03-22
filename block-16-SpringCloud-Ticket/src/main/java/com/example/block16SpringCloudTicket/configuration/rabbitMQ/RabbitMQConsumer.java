package com.example.block16SpringCloudTicket.configuration.rabbitMQ;

import com.example.block16SpringCloudTicket.domain.TripSimplify;
import com.example.block16SpringCloudTicket.repository.TripSimplifyRepository;
import org.example.dto.output.TripOutput;
import org.example.dto.output.TripOutputSimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @Autowired
    TripSimplifyRepository tripSimplifyRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(TripOutputSimple message) {
        LOGGER.info(String.format("Consuming message: %s", message));
        TripSimplify tripSimplify = new TripSimplify();
        tripSimplify.setTripId(message.getId());
        tripSimplify.setSeats(message.getSeats());
        if (tripSimplifyRepository.findByTripId(tripSimplify.getTripId()) != null) {
            tripSimplifyRepository.delete(tripSimplifyRepository.findByTripId(tripSimplify.getTripId()));
            tripSimplify.setSeats(tripSimplify.getSeats() + tripSimplifyRepository.findByTripId(tripSimplify.getTripId()).getSeats());
        }
        tripSimplifyRepository.save(tripSimplify);
    }


}
