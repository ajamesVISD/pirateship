package org.vashonsd.pirateship.creature;

public class Cow extends Creature {
	
	public Cow(String name, String description, String splash) {
		super(name, "cow", description, splash);
		setUp();
	}
	
	private void setUp() {
		this.setMaxHealth(50);
		this.setHealth(50);
		this.setTypeName("cow");
		this.setTypeNamePlural("cows");
	}
}
