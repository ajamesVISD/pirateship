package org.vashonsd.pirateship.creature;

public class NoSpeech implements SpeechBehavior {

	public String intro(Creature c) {
		return c.getName() + " is no longer one to talk.";
	}
	
	public String approach(Creature c) {
		return c.getName() + " approaches.";
	}

	public String idle(Creature c) {
		return c.getName() + " is waiting for you to move.";
	}

	public String speak(Creature c) {
		return c.getName() + " doesn't want to talk.";
	}

	public String exit(Creature c) {
		return "You leave " + c.getName();
	}

	public String failText(Creature c) {
		return c.getName() + " doesn't understand you.";
	}
}
