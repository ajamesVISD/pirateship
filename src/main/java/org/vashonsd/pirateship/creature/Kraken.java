package org.vashonsd.pirateship.creature;

public class Kraken extends Creature {

	public Kraken(String name, String description, String splash) {
		super(name, description, splash);
		this.setMaxHealth(120);
		this.setHealth(40);
	}

}
