package org.vashonsd.pirateship.creature;

public class Eagle extends Creature {

	public Eagle(String name, String description, int strength) {
		super(name, description, strength);
		this.name += " the eagle";
		this.description += ", who soars high in the sky.";
	}
	

}
