package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Fly extends EasterEgg {

	public Fly() {
		addKeywords("fly", "try to fly", "soar", "takeoff", "blast off");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You jump around and flap your arms frantically. All you accomplish is looking stupid.");
	}

}
