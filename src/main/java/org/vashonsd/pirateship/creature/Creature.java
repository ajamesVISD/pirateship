package org.vashonsd.pirateship.creature;

import java.util.ArrayList;

import org.vashonsd.pirateship.commands.*;
import org.vashonsd.pirateship.interactions.Actor;

public class Creature extends Actor {

	private SpeechBehavior speech;
	private SpeechBehavior speechDefault;
	
	public Creature(String name, String typeName, String description, String splash) {
		super(name, typeName, description, splash);
		this.enrollCommand(new Examine());
		this.enrollCommand(new Harm());
		this.enrollCommand(new Heal());
		this.enrollCommand(new Drop());
		this.enrollCommand(new Talk(this));
		this.setAlive(true);
		// Defaults creatures to no speech
		setDefaultSpeech(new NoSpeech());
	}
	
	/**
	 * Use this method when FIRST setting your creatures speech behavior,
	 * or if you want your creatures default speech to PERMENANTLY change
	 */
	public void setDefaultSpeech(SpeechBehavior s) {
		speechDefault = s;
		setSpeechBehavior(s);
	}
	
	/**
	 * Use this method ONLY when changing the speech behavior from the
	 * default speech
	 */
	public void setSpeechBehavior(SpeechBehavior s) {
		speech = s;
	}
	
	/**
	 * Use this method to revert your creatures speech behavior back
	 * to its default
	 */
	public void setSpeechToDefault()
	{
		setSpeechBehavior(speechDefault);
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
		if (held.equals("shades")) {
			setSpeechBehavior(new RebelSpeech());
			return speech.intro(this);
		}
		
		return getName() + " doesn't seem to be very interested.";
	}

	/**
	 * Refreshes a creatures if an item that affected its parameters
	 * is taken away
	 */
	public String refreshHoldingEffects() {
		String temp = speech.intro(this);
		ArrayList<Actor> tempList = this.getAllItems();
		int x = 0;
		
		for (Actor a: tempList) {
			String s = checkHoldingEffect(a);
			if (s.equals(speech.intro(this))) {
				x++;
			}
		}
		
		if (x == 0) {
			setSpeechToDefault();
		}
		
		if (!temp.equals(speech.intro(this))) {
			return getSpeechBehavior().intro(this);
		}
		
		return getName() + " doesn't seem to mind";
	}
}