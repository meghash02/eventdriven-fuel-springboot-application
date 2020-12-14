package com.megha.fuel.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main Application to start the application
 * 
 * @author Megha Sharma
 *
 */
@SpringBootApplication
// This annotation allows the asynchronous behavior and runs the methods annotated 
// with @Async annotation in the background thread pools.
@EnableAsync
// This annotation allows/enable the scheduler for the application
@EnableScheduling
@EnableSwagger2
public class EventDrivenFuelProducer {

	private static Logger logger = LoggerFactory.getLogger(EventDrivenFuelProducer.class);

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenFuelProducer.class, args);
		logger.info("Producer application started successfully");
	}
}
