package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Try extends EasterEgg {

	public Try() {
		addKeywords("try", "do something", "do a thing");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You fail.");
	}

}
