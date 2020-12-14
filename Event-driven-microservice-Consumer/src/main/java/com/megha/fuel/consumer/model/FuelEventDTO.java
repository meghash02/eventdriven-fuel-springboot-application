package com.megha.fuel.consumer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO class object from which the event type are retrieved from the queue.
 *
 * @author Megha Sharma
 *
 */
public class FuelEventDTO {
	
	public String eventType;
	public String city;
	public Double mileage;

	@JsonCreator
	public FuelEventDTO(@JsonProperty("eventType") final String eventType, 
			@JsonProperty("city") final String city, @JsonProperty("mileage") final Double mileage) {
		this.eventType = eventType;
		this.city = city;
		this.mileage= mileage;
	}

	public String getEventType() {
		return eventType;
	}

	public String getCity() {
		return city;
	}

	public Double getMileage() {
		return mileage;
	}

	@Override
	public String toString() {
		return "FuelEventDTO [eventType=" + eventType + ", city=" + city + ", mileage=" + mileage + "]";
	}

}
