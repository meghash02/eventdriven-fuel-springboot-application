package com.megha.fuel.producer.model;

/**
 * 
 * @author Megha Sharma
 *
 */
//Class object which is sent to the queue.
public class FuelEventDTO {

	public String eventType;
	public String city;
	public Double mileage;

	public FuelEventDTO(final String eventType, final String city, final Double mileage) {
		super();
		this.eventType = eventType;
		this.city = city;
		this.mileage = mileage;
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

	public static FuelEventDTO send(final String eventType, final String city, final Double mileage) {
		return new FuelEventDTO(eventType, city, mileage);
	}

	@Override
	public String toString() {
		return "FuelEventDTO [eventType=" + eventType + ", city=" + city + ", mileage=" + mileage + "]";
	}

}
