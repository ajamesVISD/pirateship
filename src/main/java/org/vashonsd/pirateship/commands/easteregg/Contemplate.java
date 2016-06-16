package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Contemplate extends EasterEgg {

	public Contemplate() {
		addKeywords("contemplate", "think", "think deeply");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("No, no, that's too difficult for you. Don't hurt yourself.");
	}

}
