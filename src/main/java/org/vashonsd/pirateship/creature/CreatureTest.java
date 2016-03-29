package org.vashonsd.pirateship.creature;


public class CreatureTest {

	public static void main(String[] args) {
		
		//Create and print new lizard
		Creature c = CreatureFactory.newCreature("lizard");
		System.out.println(c);
		
		//Create and print new eagle
		Creature newEagle = CreatureFactory.newCreature("eagle");
		System.out.println(newEagle);
		
		//create and print new kraken
		Creature newKraken = CreatureFactory.newCreature("kraken");
		System.out.println(newKraken);
	}

}
