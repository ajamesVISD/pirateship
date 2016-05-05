package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Harm extends Command {
	
	public Harm() {
		super();
		addKeyword("harm");
		addKeyword("damage");
	}

	@Override
	public Response execute(Actor i, Actor from) {
		Response r = new Response();
		String text = "";
		if (i.isAlive()) {
			i.changeHealth(-4);
			text += "You have damaged " + i.getName() + " for 4 points.";
		}
		if (i.isAlive()) {
			text += i.getDescription();
		} else {
			text += i.getName() + " is not alive.";
		}
		r.setText(text);
		return r;
	}

}
