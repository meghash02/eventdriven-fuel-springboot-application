package com.megha.fuel.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.megha.fuel.producer.model.Fuel;

/**
 * Scheduler component
 * 
 * @author Megha Sharma
 *
 */
@Component
public class Scheduler {

	@Autowired
	FuelService fuelService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// to make use of Spring scheduler it has to be no arg method and return type
	// should be void. cron expression describes as event will trigger every 2
	// minutes
	@Scheduled(cron = " 0 0/2 0 ? * * ")
	public void scheduleEvent() {
		// TODO setting hard coded values for scheduler for now.
		Fuel fuel = new Fuel("bangalore", 123.0);
		// TODO As of now sending eventType as true always need to look into the correct
		// solution
		// to how to get the false task also
		String eventType = "true";
		logger.info("every 2 min event will trigger to queue!!");
		fuelService.fuelEventPublisher(fuel, eventType);
	}
}
