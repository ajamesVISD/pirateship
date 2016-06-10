package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Suffer extends EasterEgg {

	public Suffer() {
		addKeywords("suffer", "struggle");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("Such is life.");
	}

}
