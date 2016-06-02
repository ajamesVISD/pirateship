package org.vashonsd.pirateship.creature;

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
}