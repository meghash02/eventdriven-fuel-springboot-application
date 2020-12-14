package com.megha.fuel.consumer.model;

public enum EventType {

	TRUE("true"), FALSE("false");

	public final String eventType;

	EventType(final String eventType) {
		this.eventType = eventType;
	}
}