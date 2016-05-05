package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Examine extends Command {

	public Examine() {
		super();
		this.addKeyword("examine");
		this.addKeyword("look at");
	}

	@Override
	public Response execute(Actor i, Actor from) {
		Response r = new Response();
		r.setText(i.getDescription());
		return r;
	}
}
