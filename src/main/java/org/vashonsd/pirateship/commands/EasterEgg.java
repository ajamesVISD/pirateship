package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.interactions.VisibilityLevel;

public abstract class EasterEgg extends Command {

	public EasterEgg() {
		super();
		this.visibility = VisibilityLevel.NEVER;
	}

}
