package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class TryHard extends EasterEgg {

	public TryHard() {
		addKeywords("try hard", "try harder");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You fail hard.");
	}

}
