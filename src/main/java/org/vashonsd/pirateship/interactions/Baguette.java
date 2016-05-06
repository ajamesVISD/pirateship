package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Baguette extends Actor {
	
	public Baguette() {
		super("baguette", "This baguette looks delicious.", "You see a baguette.");
		setUp();
	}
	
	public Baguette(String name, String description, String splash) {
		super(name, description, splash);
		setUp();
	}
	
	protected void setUp() {
		this.maxHealth = 20;
		this.health = maxHealth;
		this.setTypeName("baguette");
		this.setTypeNamePlural("baguettes");
		enrollCommand(new Examine());
		enrollCommand(new Harm());
		enrollCommand(new Take());
	}

	@Override
	public void changeHealth(int n) {
		this.health += n;
		checkHealth();
	}
	
	protected void checkHealth() {
		if (health < 0) {
			this.name = "Dead baguette";
			this.description = "A baguette that has somehow died.";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
}
