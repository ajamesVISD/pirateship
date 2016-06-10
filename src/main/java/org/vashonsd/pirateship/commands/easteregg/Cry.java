package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Cry extends EasterEgg {

	public Cry() {
		addKeywords("cry", "sob", "weep", "tear up");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You cry salty tears of sadness. No one cares.");
	}

}
