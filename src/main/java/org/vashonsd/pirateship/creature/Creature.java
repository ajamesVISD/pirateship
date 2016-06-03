package org.vashonsd.pirateship.creature;

import java.util.ArrayList;

import org.vashonsd.pirateship.commands.*;
import org.vashonsd.pirateship.interactions.Actor;

public class Creature extends Actor {

	private SpeechBehavior speech;
	
	public Creature(String name, String typeName, String description, String splash) {
		super(name, typeName, description, splash);
		this.enrollCommand(new Examine());
		this.enrollCommand(new Harm());
		this.enrollCommand(new Heal());
		this.enrollCommand(new Drop());
		this.enrollCommand(new Talk(this));
		this.setAlive(true);
		// Defaults creatures to no speech
		setSpeechBehavior(new NoSpeech());
	}
	
	public void setSpeechBehavior(SpeechBehavior s) {
		speech = s;
	}
	
	public SpeechBehavior getSpeechBehavior() {
		return speech;
	}
	
	public String toString() {
		return name + " the " + typeName + ": " + description;
	}

	/**
	 * Checks to see if an item given to the creature effects
	 * any of their parameters
	 */
	public String checkHoldingEffect(Actor a) {
		String held = a.getTypeName();
		
		return getName() + " doesn't seem to be very interested.";
	}

	/**
	 * Refreshes a creatures if an item that affected its parameters
	 * is taken away
	 */
	public String refreshHoldingEffects() {
		SpeechBehavior tempSpeech = getSpeechBehavior();
		ArrayList<Actor> tempList = this.getAllItems();
		for (Actor a: tempList) {
			checkHoldingEffect(a);
		}
		
		if (tempSpeech.equals(getSpeechBehavior())) {
			return getSpeechBehavior().intro(this);
		}
		
		return getName() + " doesn't seem to mind";
	}
}