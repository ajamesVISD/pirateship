package org.vashonsd.pirateship.creature;

public class Squawking implements SpeechBehavior {

	public String intro(Creature c) {
		return c.getName() + " starts squawking.";
	}

	public String approach(Creature c) {
		return c.getName() + " swoops in.";
	}

	public String idle(Creature c) {
		return c.getName() + " is trying to peck at you.";
	}

	public String speak(Creature c) {
		return c.getName() + " squawks loudly.";
	}

	public String exit(Creature c) {
		return "You leave " + c.getName() + " squawking indignantly.";
	}

	public String failText(Creature c) {
		return c.getName() + " squawks at your inability to say things that make sense.";
	}

}
