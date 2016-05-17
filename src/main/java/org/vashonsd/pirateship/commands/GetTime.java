package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class GetTime extends Command {
	
	public GetTime() {
		super();
		this.addKeywords("get time from", "check time on");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response("" + System.currentTimeMillis());
	}

}
