package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Look extends Command {

	public Look() {
		super();
		this.addKeywords("look", "look around");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response(player.look());
	}

}
