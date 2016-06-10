package org.vashonsd.pirateship.creature;

import org.vashonsd.pirateship.minigame.MinigameRunner;

public class Pig extends MinigameRunner {
	
	public Pig() {
		super("GOPP", "talk to");
		this.setName("Porky");
		this.setTypeName("pig");
		this.setDescription("There's an evil glint in his eye.");
		this.setSplashText("Your pig warden skulks in the corner.");
	}
}
