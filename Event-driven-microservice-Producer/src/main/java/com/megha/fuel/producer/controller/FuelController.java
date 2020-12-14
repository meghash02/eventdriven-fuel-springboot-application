package com.megha.fuel.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megha.fuel.producer.model.Fuel;
import com.megha.fuel.producer.service.FuelService;

/**
 * Controller class
 *
 * @author Megha Sharma
 *
 */
//Useful to create the RESTful webservices.
@RestController
@RequestMapping(value = "/api")
public class FuelController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	FuelService fuelService;

	// Saves the fuel entity.
	// @PostMapping annotation handles the http post request matched with the given
	// uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @PathVariable annotation binds the method parameter to URI template variable
	@PostMapping(value = "/event/{eventType}")
	public ResponseEntity<String> getEvent(@RequestBody final Fuel fuel, @PathVariable String eventType) {
		logger.info("Fuellid entered as  " + fuel.toString());
		final String response = fuelService.fuelEventPublisher(fuel, eventType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
