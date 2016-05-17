package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class Stopwatch extends Actor {

	public Stopwatch() {
		super("stopwatch", "stopwatch", "You hear the stopwatch faintly ticking", "You hear a stopwatch");
		setUp();
	}
	
	public Stopwatch(String name, String description, String splash) {
		super(name, "stopwatch", description, splash);
		setUp();
	}

	private void setUp() {
		this.enrollCommand(new Examine());
		this.enrollCommand(new GetTime());
		this.enrollCommand(new Take());
	}
}
