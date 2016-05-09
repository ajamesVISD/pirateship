package org.vashonsd.pirateship.creature;

import org.vashonsd.pirateship.commands.*;

public class Lizard extends Creature {

	public Lizard(String name, String description, String splash) {
		super(name, "lizard", description, splash);
		this.setMaxHealth(14);
		this.setHealth(14);
		this.setTypeName("lizard");
		this.setTypeNamePlural("lizard");
		this.enrollCommand(new Eat());
		this.enrollCommand(new Take());
	}

}
