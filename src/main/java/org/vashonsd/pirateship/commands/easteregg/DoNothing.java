package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class DoNothing extends EasterEgg {

	public DoNothing() {
		addKeywords("do nothing", "do absolutely nothing", "stand around");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("As expected, nothing happens.");
	}

}
