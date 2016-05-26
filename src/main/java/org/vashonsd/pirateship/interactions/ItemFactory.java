package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;

import org.vashonsd.pirateship.creature.*;

public class ItemFactory {
	
	private ArrayList<String> minigames = new ArrayList<String>();

	public static Actor newActor(String name, String typeName,
			String description, String splash) {
		Actor a;
		if (typeName.equalsIgnoreCase("Baguette")) {
			a = new Baguette(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Sword")) {
			a = new Sword(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Eagle")) {
			a = new Eagle(name);
		} else if (typeName.equalsIgnoreCase("Kraken")) {
			a = new Kraken(name, description, splash);
		} else if (typeName.equalsIgnoreCase("Lizard")) {
			a = new Lizard(name, description, splash);
		} else {
			a = null;
		}
		return a;
	}
}
