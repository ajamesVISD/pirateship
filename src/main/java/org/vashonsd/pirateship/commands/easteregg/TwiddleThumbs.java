package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class TwiddleThumbs extends EasterEgg {

	public TwiddleThumbs() {
		addKeywords("twiddle thumbs", "twiddle my thumbs", "be boring", "have no life");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You stand around and look bored, like a loser.");
	}

}
