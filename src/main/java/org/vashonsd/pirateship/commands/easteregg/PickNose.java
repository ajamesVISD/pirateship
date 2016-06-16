package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class PickNose extends EasterEgg {
	
	public PickNose() {
		addKeywords("pick nose", "pick my nose");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You pick your nose without shame. Who cares who's watching?");
	}

}
