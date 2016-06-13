package org.vashonsd.pirateship.creature;

import java.util.Random;

public class CowPunSpeech implements SpeechBehavior {

	public String intro(Creature c) {
		return c.getName() + " suddenly has the urge to tell terrible jokes.";
	}

	public String approach(Creature c) {
		return c.getName() + " is here and ready to tell bad jokes.";
	}

	public String idle(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " is hurt, but tries to laugh the pain away.";
		}
		return c.getName() + " is checking for laughs.";
	}

	public String speak(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " wants to tell a joke, but is too scared.";
		}
		String text = c.getName() + " wants to tell you a joke.\n";
		Random ran = new Random();
		int x = ran.nextInt(3);
		if (x == 0) {
			text += "\"What makes a professional cow?...They're OUTSTANDING in their field.\"";
		}
		if (x == 1) {
			text += "\"What did the mommy cow say to the baby cow?...It's PASTURE bedtime.\"";
		}
		if (x == 2) {
			text += "\"Why did the cow climb the hill?...It wanted to RAISE THE STEAKS.\"";
		}
		return text;
	}

	public String exit(Creature c) {
		return c.getName() + " says you can cow-nt on him to be here.";
	}

	public String failText(Creature c) {
		return c.getName() + " is a little cow-nfused.";
	}

}
