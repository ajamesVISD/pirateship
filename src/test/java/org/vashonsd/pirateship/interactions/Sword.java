package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Examine;

public class Sword extends Actor {

	public Sword() {
		super("sword", "It's a little rusty, but usable.");
		setUp();
	}
	
	public Sword(String description) {
		super("sword", description);
		setUp();
	}
	
	public Sword(String name, String description) {
		super(name, description);
		setUp();
	}
	
	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeNamePlural("swords");
		this.setTypeName("sword");
	}
}
