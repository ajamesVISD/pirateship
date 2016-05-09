package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Examine;

public class Sword extends Actor {

	public Sword() {
		super("sword", "sword", "It's a little rusty, but usable.", "There is a sword here.");
		setUp();
	}
	
	public Sword(String description) {
		super("sword", "sword", description, "There is a sword here.");
		setUp();
	}
	
	public Sword(String name, String description, String splash) {
		super(name, "sword", description, splash);
		setUp();
	}
	
	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeNamePlural("swords");
		this.setTypeName("sword");
	}
}
