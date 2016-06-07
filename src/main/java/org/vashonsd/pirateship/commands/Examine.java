package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Examine extends Command {

	public Examine() {
		super();
		this.addKeywords("examine", "look at", "check", "check out");
	}

	@Override
	public Response execute(Actor i, Player from) {
		Response r = new Response();
		r.setText(i.getDescription());
		return r;
	}
}
