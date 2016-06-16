package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Dance extends EasterEgg {
		
	public Dance() {
		addKeywords("dance", "do a dance", "boogey");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You do a dance. Not a fabulous dance. Just a regular dance.");
	}

}
