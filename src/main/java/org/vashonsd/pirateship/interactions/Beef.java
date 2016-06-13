package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Eat;
import org.vashonsd.pirateship.commands.Examine;
import org.vashonsd.pirateship.commands.Take;

public class Beef extends Actor {

	public Beef() {
		super("beef", "beef", "It's raw.", "there's a slab of beef on the shelf.");
		setUp();
	}
	
	
	protected void setUp() {
		this.setAlive(true);
		this.maxHealth = 40;
		this.health = maxHealth;
		this.setTypeName("beef");
		this.setTypeNamePlural("beef");
		enrollCommand(new Examine());
		enrollCommand(new Take());
		enrollCommand(new Eat());
	}

@Override
public void changeHealth(int n) {
	this.health += n;
	checkHealth();
}

protected void checkHealth() {
	if (health < 0) {
		this.name = "beef remenants";
		this.description = "Nothing but a memory of beef.";
	}
	if (health < 20) {
		this.name = "half-eaten beef";
		this.description = "Half-eaten beef. That's some lean meat.";
	}
	if (health > maxHealth) {
		health = maxHealth;
	}
}

}
