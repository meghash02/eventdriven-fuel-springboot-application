package com.megha.fuel.consumer.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megha.fuel.consumer.model.FuelEventDTO;
import com.megha.fuel.consumer.model.FuelPrice;

// Service class that will consume the message from the given queue as soon as they are published/pushed to the queue.
@Service
public class ConsumerFuelService {

	private Logger logger = LoggerFactory.getLogger(ConsumerFuelService.class);

	@Autowired
	com.megha.fuel.consumer.repository.FuelPriceRepository fuelPriceRepository;

	// Annotation allows the message to be listened at the given queue.
	// Queue name is directly read from the properties file.
	@RabbitListener(queues = "${fuel.event.queue}")
	public void recievedFuelMessage(final FuelEventDTO fuelEventDTO) {
		logger.info("Received message from rabbitMq= " + fuelEventDTO);
		for (FuelPrice fp : fuelPriceRepository.findByCity(fuelEventDTO.getCity())) {
			Double priceToPay = fp.getFuelPrice();
			calculateFuelAmountAndPrice(priceToPay, fuelEventDTO.getMileage());
		}

	}

	private void calculateFuelAmountAndPrice(Double priceToPay, Double mileage) {
		Double capacityOfTankInLit = 25.0; // keeping it hardcoded as of now... we can create Car table entity also to
											// get the the details of car like capacity of the tank etc..
		Double amount = capacityOfTankInLit / mileage;
		logger.info("Amount of fuel in litres got into the tank " + amount);
		Double litVehicleConsumed = mileage * (amount / 100);
		Double price = litVehicleConsumed * priceToPay;
		logger.info("Price paid : " + price);

	}
}
