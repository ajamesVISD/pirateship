package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.easteregg.EasterEgg;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Leap extends EasterEgg {

	public Leap() {
		super();
		this.addKeyword("test");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("pass");
	}

}
