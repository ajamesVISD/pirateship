package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Bandage extends Actor {

	public Bandage() {
		super("bandage", "bandage", "This will help the pain", "There is a bandage here.");
		setUp();
	}
	
	public Bandage(String description) {
		super("bandage", "bandage", description, "There is a bandage here.");
		setUp();
	}
	
	public Bandage(String name, String description, String splash) {
		super(name, "bandage", description, splash);
		setUp();
	}

	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeNamePlural("bandage");
		this.setTypeName("bandage");
		this.enrollCommand(new Take());
		this.enrollCommand(new Drop());
	}
}
