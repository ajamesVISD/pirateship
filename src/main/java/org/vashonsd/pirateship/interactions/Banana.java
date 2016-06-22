package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Banana extends Actor {

	public Banana(String name, String description, String splash) {
		super(name, "banana", description, splash);
	}
	
	public Banana() {
		super("banana", "banana", "It has brown spots but looks tasty.", "There is a banana here.");
		setUp();
	}

	private void setUp() {
		this.setAlive(true);
		this.maxHealth=10;
		this.health=maxHealth;
		this.setTypeName("banana");
		this.setTypeNamePlural("bananas");
		enrollCommand(new Examine());
		enrollCommand(new Eat());
		enrollCommand(new Harm());
		enrollCommand(new Take());
	}
	
	public void changeHealth(int n) {
		this.health += n;
		checkHealth();
	}
	
	protected void checkHealth() {
		if (health < 0) {
			this.name = "banana peel";
			this.description = "Just a peel of a banana";
		}
		if (health < 10) {
			this.name = "a half-eaten banana";
			this.description = "A banana. Half of it is eaten.";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}

}
