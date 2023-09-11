package com.backfcdev.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@Configuration
public class KafkaConsumerListener {

    @KafkaListener(topics = "unProgramadorBackend-topic", groupId = "my-group-id")
    public void listener(String message) {
        log.info("Message received, the message is: {}", message);
    }
}
