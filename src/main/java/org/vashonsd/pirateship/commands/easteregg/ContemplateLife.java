package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class ContemplateLife extends EasterEgg {

	public ContemplateLife() {
		addKeywords("contemplate life", "think about life", "think about the meaning of life");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You come to the conclusion that life is a dark, sad place without hope. You weep.");
	}

}
