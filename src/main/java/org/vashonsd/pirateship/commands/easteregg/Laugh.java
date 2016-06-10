package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Laugh extends EasterEgg {

	public Laugh() {
		addKeywords("laugh", "chuckle");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You break out into laughter fpr no reason. People start giving you a wide berth.");
	}

}
