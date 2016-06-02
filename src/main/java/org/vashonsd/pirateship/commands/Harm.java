package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.*;


public class Harm extends Command {
	
	public Harm() {
		super();
		addKeywords("harm", "damage", "attack");
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
