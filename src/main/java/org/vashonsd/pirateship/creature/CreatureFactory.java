package org.vashonsd.pirateship.creature;

public class CreatureFactory {
	
	public static Creature newCreature(String which) {
		if (which.equals("lizard")) {
			return new Lizard("Little Larry", "It is sleek and green", "There is a lizard here.");
		}
		else if(which.equals("eagle")) {
			return new Eagle("Daniel");
		}
		else if(which.equals("kraken")) {
			return new Kraken("The Kraken", "Ships Beware!", "You hear the ominous sounds of a Kraken!");
		}
		else if(which.equals("dog")) {
			return new Dog("Jake the Dog", "He is a loyal Labrador", "A dog is wagging his tail");
		}
		else if(which.equals("cow")) {
			return new Cow("Moofred", "His name is a joke, just like his life", "A cow grazes");
		}
		else {
			return null;
		}
	}
}
