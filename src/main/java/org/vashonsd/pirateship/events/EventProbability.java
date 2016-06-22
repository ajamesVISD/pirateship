package org.vashonsd.pirateship.events;

import java.util.Random;


/**
 * @author roed.conner
 * This matches an Event to a likelihood of that event.
 * It should be able to call this instance and either get back that event or not, depending on its probability.
 * 
 * For example: 
 * Set up a 100% chance of rain. Calling this EventProbability.get() should get you the Rain event every time.
 * Set up a 5% chance of a hurricane. Call this EventProbability.get() should have a 5% chance of returning
 * a hurricane.
 * 
 */
public class EventProbability {
	private Event event;
	private int probability;
	
	public EventProbability(Event event, int probability) {
		super();
		this.event = event;
		this.probability = probability;
	}

	/*
	 * This rolls the dice on this event and, deepening on the dice roll, either returns it or returns null.
	 */
	public Event get() {
		Random rand = new Random();
		if(rand.nextInt(100)+1 <= probability){
			return event;
		} else {
			return null;
		}
	}
}
