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
		else if(which.equals("cowner")) {
			Creature c = new Cow("Cowner", "He thinks he's pretty a-moo-sing.", "There's a cow making terrible bad jokes.");
			return c;
		}
		else if (which.equals("moofred")) {
			Creature c = new Cow("Moofred", "He was last years olympic champion mastication.", "You see a cow doing mad bench presses.");
			return c;
		}
		else if (which.equals("ribecca")) {
			Creature c = new Cow("Ribecca", "She's wearing sparkly hoofpolish.", "There's a pretty cow receptionist.");
			return c;
		}
		else if (which.equals("hoofley")) {
			Creature c = new Cow("Hoofley", "", "There's a cow sorting through mail.");
			return c;
		}
		else if (which.equals("beefanca")) {
			Creature c = new Cow("Beefanca", "She's ready to improve your shopping experience.", "A cow greets you from behind the counter.");
			return c;
		}
		else if (which.equals("steakbastion")) {
			Creature c = new Cow("Steakbastion", "He's wardrobe is rather dapper for this side of town.", "A bartender cow stands coolly at the counter.");
			return c;
		}
		else if (which.equals("cudsmo")) {
			Creature c = new Cow("Cudsmo", "He might have a beef to pick with you.", "You see a cow, hidden in the shadows.");
			return c;
		}
		else if (which.equals("grazelda")) {
			Creature c = new Cow("Grazelda", "She looks disallusioned with life.", "");
			return c;
		}
		else if (which.equals("larry")) {
			Creature c = new Cow("Larry", "This is the stuff losers are made of.", "");
			return c;
		}
		else {
			return null;
		}
	}
}
