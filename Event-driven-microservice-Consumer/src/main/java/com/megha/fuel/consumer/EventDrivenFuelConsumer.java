package com.megha.fuel.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// Enable rabbit listener endpoints.
@EnableRabbit
@EnableSwagger2
@ImportResource("/springamqp-rabbit-sender-context.xml")
public class EventDrivenFuelConsumer {

	private static Logger logger = LoggerFactory.getLogger(EventDrivenFuelConsumer.class);

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenFuelConsumer.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventDrivenFuelConsumer.class);
		ctx.refresh();
		logger.info("Event driven microservice consumer application started successfully.");
	}
}
