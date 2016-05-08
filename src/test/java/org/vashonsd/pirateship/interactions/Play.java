package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Command;

public class Play extends Command {
	
	public Play() {
		super();
		this.addKeyword("play");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You play the " + obj.getName() + ".");
	}

}
