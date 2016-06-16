package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class DanceFab extends EasterEgg {
	
	public DanceFab() {
		addKeywords("dance fabulously", "do a fabulous dance", "fabulous dance", "boogey hard");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You dance like a rock star. Crowds gather to watch your performance.");
	}

}
