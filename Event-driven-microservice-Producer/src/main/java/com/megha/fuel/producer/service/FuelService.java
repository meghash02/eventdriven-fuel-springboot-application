package com.megha.fuel.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.megha.fuel.producer.model.EventType;
import com.megha.fuel.producer.model.Fuel;
import com.megha.fuel.producer.model.FuelEventDTO;

/**
 * Service Class
 * 
 * @author Megha Sharma
 *
 */
@Service
public class FuelService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// Getting the rabbitMqTemplate object for sending the fuel object to the
	// queue where a consumer
	// is listening and will process the fuel object further.
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Value("${fuel.event.queue}")
	String fuelEventQueue;

	@SuppressWarnings("unlikely-arg-type")
	public String fuelEventPublisher(Fuel fuel, String eventType) {
		if (eventType.equals(EventType.TRUE.eventType)) {
			logger.info("Fuel Lid of the car is open!!");
			publishEventToRabbitMq(fuel.getCity(), EventType.TRUE.eventType, fuel.getMileage());
		} else {
			logger.info("Fuel Lid of the car is closed!!");
			publishEventToRabbitMq(fuel.getCity(), EventType.FALSE.eventType, fuel.getMileage());
		}
		final String response = "[ city : " + fuel.getCity() + "event Type is : ," + eventType + "and mileage is :"
				+ fuel.getMileage() + "] sent successfully.";
		return response;
	}

	@Async
	private void publishEventToRabbitMq(final String city, final String eventType, final Double mileage) {
		final FuelEventDTO eventDto = FuelEventDTO.send(eventType, city, mileage);
		logger.info("Sending the following event object to the queue: " + eventDto);
		// Sending the fuellid type and city object to the rabbitmq queue where a
		// designated consumer will listen to the event
		// coming on this queue and process the further activities.
		rabbitTemplate.convertAndSend(fuelEventQueue, eventDto);
		logger.info("Message successfully sent to the rabbitMq.");
	}

}
