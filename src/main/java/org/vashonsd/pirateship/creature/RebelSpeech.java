package org.vashonsd.pirateship.creature;

public class RebelSpeech implements SpeechBehavior {

	public String intro(Creature c) {
		return c.getName() + " is a rebel now. It say what it want.";
	}

	public String approach(Creature c) {
		return c.getName() + " saunters over...coolly.";
	}

	public String idle(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " is trying hard to keep its cool.";
		}
		return c.getName() + " is being super edgy.";
	}

	public String speak(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " tells you to scram.";
		}
		return c.getName() + " tells you your face is dumb. Unlike its face.";
	}

	public String exit(Creature c) {
		return c.getName() + " makes sure you know it didn't want to hang with you either.";
	}

	public String failText(Creature c) {
		return c.getName() + " is baffled at your inability to make sense.";
	}

}
