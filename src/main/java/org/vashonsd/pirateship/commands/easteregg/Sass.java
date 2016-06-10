package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Sass extends EasterEgg {

	public Sass() {
		addKeywords("sass", "be sassy", "snap sassily", "say something sassy");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You say something sassy and snap your fingers. No one is impressed.");
	}

}
