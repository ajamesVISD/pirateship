package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Strut extends EasterEgg {

	public Strut() {
		addKeywords("strut", "walk fabulously", "be a model", "be fabulous");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You strut about like a model on a walkway. People start snapping pictures.");
	}

}
