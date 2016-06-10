package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Smile extends EasterEgg {

	public Smile() {
		addKeyword("smile");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("Your smile is scaring children, please stop.");
	}

}
