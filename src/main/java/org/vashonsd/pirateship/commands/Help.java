package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.interactions.VisibilityLevel;

public class Help extends Command {

	public Help() {
		super();
		addKeyword("help");
	}
	
	@Override
	public Response execute(Actor obj, Player from) {
		return new Response(from.displayCommands(VisibilityLevel.EXAMINE));
	}

}
