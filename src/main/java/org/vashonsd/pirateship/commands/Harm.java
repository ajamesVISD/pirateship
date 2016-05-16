package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Harm extends Command {
	
	public Harm() {
		super();
		addKeyword("harm");
		addKeyword("damage");
	}

	@Override
	public Response execute(Actor obj, Player from) {
		Response r = new Response();
		String text = "";
		if (obj.isAlive()) {
			obj.changeHealth(-4);
			text += "You have damaged " + obj.getName() + " for 4 points.";
		}
		if (obj.isAlive()) {
			text += obj.getDescription();
		} else {
			text += obj.getName() + " is not alive.";
		}
		r.setText(text);
		return r;
	}

}
