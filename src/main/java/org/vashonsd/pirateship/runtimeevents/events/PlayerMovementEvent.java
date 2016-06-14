package org.vashonsd.pirateship.runtimeevents.events;

import java.util.EventObject;

import org.vashonsd.pirateship.interactions.Actor;

public class PlayerMovementEvent extends EventObject {
	
	private Actor currentLocation;

	public PlayerMovementEvent(Object source, Actor currentLocation) {
		super(source);
		this.currentLocation = currentLocation;
	}
	
	public Actor getCurrentLocation() {
		return this.currentLocation;
	}
}
