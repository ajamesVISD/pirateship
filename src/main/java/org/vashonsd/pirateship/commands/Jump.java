package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Jump extends EasterEgg {

	public Jump() {
		addKeywords("jump","leap");
	}
	
	@Override
	public Response execute(Actor obj, Actor from) {
		return new Response("You leap into the air. You look like an idiot.");
	}

}
