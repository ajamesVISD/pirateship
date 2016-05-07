package org.vashonsd.pirateship.creature;

public class CreatureFactory {
	
	public static Creature newCreature(String which) {
		if (which.equals("lizard")) {
			return new Lizard("lizard", "It is sleek and green", "There is a lizard here.");
		}
		else if(which.equals("eagle")) {
			return new Eagle("eagle");
		}
		else if(which.equals("kraken")) {
			return new Kraken("The Kraken", "Ships Beware!", "You hear the ominous sounds of a Kraken!");
		}
		else {
			return null;
		}
	}
}
