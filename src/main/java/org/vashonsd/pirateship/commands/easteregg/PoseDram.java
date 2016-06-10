package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class PoseDram extends EasterEgg {

	public PoseDram() {
		addKeywords("strike dramatic pose", "strike a dramatic pose", "pose dramatically");
		addKeywords("be the bee's knees", "be the cat's pajamas");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You strike a dramatic pose. People are awed by your fantastic style.");
	}

}
