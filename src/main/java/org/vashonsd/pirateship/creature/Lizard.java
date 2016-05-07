package org.vashonsd.pirateship.creature;

public class Lizard extends Creature {

	public Lizard(String name, String description, String splash) {
		super(name, description, splash);
		this.setMaxHealth(14);
		this.setHealth(14);
		this.setTypeName("lizard");
		this.setTypeNamePlural("lizard");
	}

}
