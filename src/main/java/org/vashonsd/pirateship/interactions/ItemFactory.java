package org.vashonsd.pirateship.interactions;


import org.vashonsd.pirateship.creature.*;
import org.vashonsd.pirateship.minigame.MinigameRunner;

public class ItemFactory {
	
	private static String[] minigames = new String[] {"20Q", "Blackjack", "CC", "GF", "GuessCalc", "math", "GOPP", "Shot", "TTT"};

	public static Actor newActor(String name, String typeName,
			String description, String splash) {
		Actor a;
		if(isMinigame(typeName)) {
			a = new MinigameRunner(typeName);
		} else if (typeName.equalsIgnoreCase("Baguette")) {
			a = new Baguette(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Sword")) {
			a = new Sword(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Bandage")) {
			a = new Bandage(name, description, splash);
		} else if (typeName.equalsIgnoreCase("StopWatch")) {
			a = new StopWatch(name);
		} else if (typeName.equalsIgnoreCase("Eagle")) {
			a = new Eagle(name);
		} else if (typeName.equalsIgnoreCase("Kraken")) {
			a = new Kraken(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Lizard")) {
			a = new Lizard(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Dog")) {
			a = new Dog(name, description, splash);
		} else {
			a = null;
		}
		return a;
	}
	
	private static boolean isMinigame(String typeName) {
		for(String s: minigames) {
			if(s.equalsIgnoreCase(typeName)) {
				return true;
			}
		}
		return false;
	}
}
