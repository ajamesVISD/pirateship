package org.vashonsd.pirateship.creature;

import org.vashonsd.pirateship.interactions.Actor;

public class Cow extends Creature {
	
	public Cow(String name, String description, String splash) {
		super(name, "cow", description, splash);
		setUp();
	}
	
	private void setUp() {
		this.setMaxHealth(50);
		this.setHealth(50);
		this.setTypeName("cow");
		this.setTypeNamePlural("cows");
	}
	
	@Override
	public String checkHoldingEffect(Actor a) {
		String held = a.getTypeName();
		if (held.equals("shades")) {
			setSpeechBehavior(new RebelSpeech());
			return getSpeechBehavior().intro(this);
		} else if (held.equals("beef")) {
			setSpeechBehavior(new HorrifiedSpeech());
			return getSpeechBehavior().intro(this);
		}
		
		return getName() + " doesn't give a cow.";
	}
}
