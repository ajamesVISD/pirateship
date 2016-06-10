package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Pose extends EasterEgg {

	public Pose() {
		addKeywords("pose", "strike pose", "strike a pose", "model", "be cool");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You strike a weak pose. It lacks dramatic flair and is not very impressive.");
	}

}
