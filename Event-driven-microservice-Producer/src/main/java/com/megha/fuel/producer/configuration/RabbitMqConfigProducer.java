package com.megha.fuel.producer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for RabbitMq
 * 
 * @author Megha Sharma
 *
 */
// Required to declare an exchange, a queue, and a message converter on application startup.
@Configuration
public class RabbitMqConfigProducer {

	@Value("${fuel.event.queue}")
	String fuelEventQueue;

	@Bean
	Queue queue() {
		return new Queue(fuelEventQueue);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
