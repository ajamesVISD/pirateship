package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Axe extends Actor{
	public Axe() {
		super("axe", "axe", "It could probably be used to cut down a tree.", "There is an axe here.");
		setUp();
	}
	
	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeName("axes");
		this.setTypeNamePlural("axes");
	}

	public Axe(String description) {
		super("axe", "axe", description, "There is an axe here.");
	}
	
	public Axe(String name, String description, String splash) {
		super(name, "axe", description, splash);
		setUp();
	}
}
