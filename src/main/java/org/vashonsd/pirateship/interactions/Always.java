package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Inventory;
import org.vashonsd.pirateship.commands.*;

/**
 * Always is the Actor that is always present. Creepy, I know. In practice, though, Always is just the carrier for
 * commands that always pertain to the user; for example: "inventory".
 * 
 * Always is the final handler when no object can be found for other methods. This means that its handler should *always*
 * return something.
 * 
 * @author andy
 *
 */
public class Always extends Actor {
	
	public Always() {
		super("", "always", "", "");
		this.enrollCommand(new Inventory());
		this.enrollCommand(new Jump());
		this.enrollCommand(new Help());
		this.enrollCommand(new Look());
		this.setVisibility(VisibilityLevel.NEVER);
	}

	@Override
	protected Response handleOtherwise(Request req) {
		return new Response("I'm sorry, I don't understand that command.");
	}
}
