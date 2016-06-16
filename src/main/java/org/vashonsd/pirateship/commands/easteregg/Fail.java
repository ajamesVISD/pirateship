package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Fail extends EasterEgg {

	public Fail() {
		addKeywords("fail", "be a fail", "fail at life", "suck at life");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You think that maybe you should try doing something else with your life.");
	}

}
