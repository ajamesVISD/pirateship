package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.*;



public class Drop extends Command {
	
	public Drop() {
		super();
		this.addKeywords("Drop", "drop");
	}

	@Override
	public Response execute(Actor obj, Player from) {
		Response r = new Response();
		String text = "";
		text += "You have dropped " + obj.getName();
		from.removeFromInventory(obj);
		from.getLocation().addToInventory(obj);
		r.setText(text);
		return r;
	}
	
	
}

