package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Faceplant extends EasterEgg {

	public Faceplant() {
		addKeywords("faceplant", "fall over");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You take a dramatic tumble, face smashing into the ground. It's an improvement, to say the least.");
	}

}
