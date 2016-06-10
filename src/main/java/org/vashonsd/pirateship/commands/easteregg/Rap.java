package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Rap extends EasterEgg {

	public Rap() {
		addKeywords("rap", "do a rap");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You attempt to convince people you're from the hood by belting out a quick rap. No one is impressed.");
	}

}
