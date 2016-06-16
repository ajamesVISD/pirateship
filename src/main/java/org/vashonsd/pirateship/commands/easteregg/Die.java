package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Die extends EasterEgg {

	public Die() {
		addKeywords("die", "perish", "suicide");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You try to die with pure willpower alone. It doesn't work.");
	}

}
