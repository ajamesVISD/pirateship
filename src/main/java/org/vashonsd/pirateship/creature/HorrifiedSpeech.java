package org.vashonsd.pirateship.creature;

public class HorrifiedSpeech implements SpeechBehavior {

	public String intro(Creature c) {
		return c.getName() + " is horrified";
	}

	public String approach(Creature c) {
		return c.getName() + " doesn't look happy to see you.";
	}

	public String idle(Creature c) {
		return c.getName() + " is rightfully disturbed by you.";
	}

	public String speak(Creature c) {
		return c.getName() + " is too horrified to speak.";
	}

	public String exit(Creature c) {
		return c.getName() + " is glad to see you leave.";
	}

	public String failText(Creature c) {
		return c.getName() + " is horrified as well as confused.";
	}

}
