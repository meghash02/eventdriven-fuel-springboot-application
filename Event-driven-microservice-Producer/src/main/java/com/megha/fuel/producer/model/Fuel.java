package com.megha.fuel.producer.model;

/**
 * Simple pojo class that will be used in the post request.
 * 
 * @author Megha
 *
 */
public class Fuel {

	public String city;
	public Double mileage;

	public void setCity(String city) {
		this.city = city;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Fuel(String city, Double mileage) {
		super();
		this.city = city;
		this.mileage = mileage;
	}

	public String getCity() {
		return city;
	}

	public Double getMileage() {
		return mileage;
	}

	@Override
	public String toString() {
		return "Fuel [ city=" + city + ", mileage=" + mileage + "]";
	}

}
