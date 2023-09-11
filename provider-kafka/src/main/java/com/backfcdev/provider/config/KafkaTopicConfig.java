package com.backfcdev.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {
        return TopicBuilder.name("unProgramadorBackend-topic")
                .partitions(2) // Número de particiones
                .replicas(2) // Número de réplicas
                .configs(configurations())
                .build();
    }

    private static Map<String, String> configurations() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (borra mensaje) - compact (Mantiene el más actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Tiempo de retención/duration de mensajes, defecto -1 = no se borra nunca
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamanio maxim del segmento - defecto 1073741824 bytes - 1 GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamanio maxim de cada mensaje - defecto 1000000 - 1 MB
        return configurations;
    }
}