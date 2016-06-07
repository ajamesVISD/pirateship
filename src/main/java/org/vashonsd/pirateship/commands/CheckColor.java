package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class CheckColor extends Command {

	public CheckColor() {
		super();
		this.addKeywords("check color of");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response(""+obj.checkColor());
	}

}
