package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Backflip extends EasterEgg {

	public Backflip() {
		addKeywords("backflip", "do a backflip", "attempt a backflip");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You attempt a backflip, only to fall and break your neck. Whoops.");
	}

}
