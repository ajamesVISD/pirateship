package org.vashonsd.pirateship.creature;

public class Lizard extends Creature {

	public Lizard(String name, String description, int strength) {
		super(name, description, strength);
		this.name += " the Lizard";
		this.description += ", and is a lizard.";
	}

}
