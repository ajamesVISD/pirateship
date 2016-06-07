package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Shovel extends Actor {

	public Shovel(String name, String typeName, String description, String splash) {
		super(name, "Shovel", description, splash);
	}
	
	public Shovel() {
		super("shovel", "shovel", "It's rusty and dirty.", "You see a shovel.");
		setUp();
	}

	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeName("shovel");
		this.setTypeNamePlural("shovels");
	}
	
	public Shovel(String description) {
		super("shovel", "shovel", description, "You see a shovel.");
		setUp();
	}
}
