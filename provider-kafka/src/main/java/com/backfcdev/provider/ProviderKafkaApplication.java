package com.backfcdev.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProviderKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderKafkaApplication.class, args);
	}


	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("unProgramadorBackend-topic", "Final test of Spring Boot with Kafka!");
		};
	}
}
