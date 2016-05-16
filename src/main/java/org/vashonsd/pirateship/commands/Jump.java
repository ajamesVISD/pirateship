package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Jump extends EasterEgg {

	public Jump() {
		super();
		addKeywords("jump","leap");
	}
	
	@Override
	public Response execute(Actor obj, Player from) {
		return new Response("You leap into the air. You look like an idiot.");
	}
}
