package com.megha.fuel.consumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel")
public class FuelPrice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String id;

	@Column
	String city;

	@Column
	Double fuelPrice;

	public FuelPrice(String id, String city, Double fuelPrice) {
		super();
		this.id = id;
		this.city = city;
		this.fuelPrice = fuelPrice;
	}

	public FuelPrice() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(Double fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	@Override
	public String toString() {
		return "FuelPrice [id=" + id + ", city=" + city + ", fuelPrice=" + fuelPrice + "]";
	}

}
