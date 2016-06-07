package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class LWGem extends Actor {

	public LWGem(String name, String typeName, String description, String splash) {
		super(name, "Gem", description, splash);
		}
	
	public LWGem() {
		super("gem", "gem", "The polished gem has a green glow.", "There is a gem");
		setUp();
	}

	private void setUp() {
		enrollCommand(new Examine());
		setTypeName("gem");
		setTypeNamePlural("gems");
	}

}
