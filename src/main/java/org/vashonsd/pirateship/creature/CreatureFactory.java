package org.vashonsd.pirateship.creature;

public class CreatureFactory {
	
	public static Creature newCreature(String which) {
		if (which.equals("lizard")) {
			return new Lizard("Bob", "It is sleek and green", 10);
		}
		else if(which.equals("eagle")) {
			return new Eagle("Dom", "A strong and powerful bald eagle", 25);
		}
		else if(which.equals("kraken")) {
			return new Kraken("The Kraken", "Ships Beware!", 100);
		}
		else {
			return null;
		}
	}
}
