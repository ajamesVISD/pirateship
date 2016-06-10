package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Shout extends EasterEgg {

	public Shout() {
		addKeywords("shout", "yell", "plead", "beg");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You shout out to the world, begging to be heard. No one cares.");
	}

}
