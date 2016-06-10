package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Live extends EasterEgg {

	public Live() {
		addKeywords("live", "survive", "succeed", "win");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		player.setHealth(0);
		return new Response("Life says 'no' and then kills you.");
	}

}
