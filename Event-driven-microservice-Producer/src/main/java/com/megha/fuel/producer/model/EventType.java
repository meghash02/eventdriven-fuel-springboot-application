package com.megha.fuel.producer.model;

// An enum to send the correct status of the event type.
public enum EventType {

	TRUE("true"), FALSE("FALSE");

	public final String eventType;

	EventType(final String eventType) {
		this.eventType = eventType;
	}
}