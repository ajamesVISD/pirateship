package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.interactions.VisibilityLevel;

public abstract class EasterEgg extends Command {

	public EasterEgg() {
		super();
		this.visibility = VisibilityLevel.NEVER;
	}

}
