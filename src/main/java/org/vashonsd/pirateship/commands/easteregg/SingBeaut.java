package org.vashonsd.pirateship.commands.easteregg;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class SingBeaut extends EasterEgg {

	public SingBeaut() {
		addKeywords("sing beautifully", "sing a beautiful song");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("You break out into a gorgeous ballad. Everyone stops to listen.");
	}

}
