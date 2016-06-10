package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Sing extends EasterEgg {

	public Sing() {
		addKeywords("sing", "sing a song");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You sing a little tune. Your singing sucks.");
	}

}
