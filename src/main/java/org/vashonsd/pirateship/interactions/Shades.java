package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Examine;
import org.vashonsd.pirateship.commands.Take;

public class Shades extends Actor {

	public Shades() {
		super("shades", "shades", "these shades are super cool.", "you see a pair of shades.");
		this.setAlive(false);
		this.setTypeNamePlural("shades");
		enrollCommand(new Examine());
		enrollCommand(new Take());
	}
}
