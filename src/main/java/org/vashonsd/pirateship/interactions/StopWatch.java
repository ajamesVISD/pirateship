package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class StopWatch extends Actor {

	public StopWatch(String name) {
		super(name, "stopwatch", "You hear a stopwatch ticking" , "You hear a stopwatch");
		// TODO Auto-generated constructor stub
		this.enrollCommand(new Examine());
		this.enrollCommand(new GetTime());
		this.enrollCommand(new Take());
		this.enrollCommand(new Drop());
	}

}
