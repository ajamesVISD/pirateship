package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public abstract class EasterEgg extends Command {

	public EasterEgg() {
		super();
		this.visibility = VisibilityLevel.NEVER;
	}
	
	@Override
	public abstract Response execute(Actor obj, Actor from);

}
