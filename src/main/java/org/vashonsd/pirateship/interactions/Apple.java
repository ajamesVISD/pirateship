package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;


public class Apple extends Actor{

	public Apple(String name, String typeName, String description, String splash) {
		super(name, "apple", description, splash);
	}
	
	public Apple() {
		super("apple", "apple", "Fresh as it gets.", "There is an apple here.");
		setUp();
	}

	private void setUp() {
		this.setAlive(true);
		this.maxHealth=10;
		this.health=maxHealth;
		this.setTypeName("apple");
		this.setTypeNamePlural("apples");
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
			this.name = "apple core";
			this.description = "You decide not to eat the core";
		}
		if (health < 6) {
			this.name = "a half-eaten apple";
			this.description = "An apple. Half of it is eaten.";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}

}
