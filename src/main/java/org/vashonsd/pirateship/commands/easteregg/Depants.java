package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Depants extends EasterEgg {

	public Depants() {
		addKeywords("depants", "pull down pants", "remove pants");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You strip yourself of those cumbersome pants. A feeling of freedom washes over you.");
	}

}
