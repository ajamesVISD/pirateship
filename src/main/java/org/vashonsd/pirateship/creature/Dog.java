package org.vashonsd.pirateship.creature;

import org.vashonsd.pirateship.commands.*;

public class Dog extends Creature {
	public Dog(String name,String description, String splash) {
		super(name, "dog", "It is a loyal dog who will stay by your side", "A dog wags its tail");
		this.setMaxHealth(30);
		this.setHealth(20);
		this.setTypeName("dog");
		this.setTypeNamePlural("dogs");
		this.enrollCommand(new Take());
		this.enrollCommand(new Drop());
		this.enrollCommand(new Heal());
		this.enrollCommand(new Harm());
	}
}
