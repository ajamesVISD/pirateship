package org.vashonsd.pirateship.runtimeevents.events;

import java.util.EventObject;

import org.vashonsd.pirateship.interactions.Actor;

public class PlayerInventoryEvent extends EventObject {

	private Actor recipient;

	public PlayerInventoryEvent(Object source, Actor recipient) {
		super(source);
		this.recipient = recipient;
	}
	
	public Actor getRecipient() {
		return this.recipient;
	}
}
