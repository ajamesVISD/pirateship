package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Baguette extends Actor {
	
		public Baguette() {
			super("baguette", "baguette", "This baguette looks delicious.", "You see a baguette.");
			setUp();
		}
		
		public Baguette(String name, String description, String splash) {
			super(name, "baguette", description, splash);
			setUp();
		}
		
		protected void setUp() {
			this.setAlive(true);
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
			this.name = "baguette crumbs";
			this.description = "What once was a delicious baguette.";
		}
		if (health < 20) {
			this.name = "a half-eaten baguette";
			this.description = "A baguette. It is half-eaten.";
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
}
