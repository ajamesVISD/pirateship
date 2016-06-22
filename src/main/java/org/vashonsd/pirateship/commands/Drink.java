package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.*;


public class Drink extends Command {
	
	public Drink() {
		addKeyword("drink");
		addKeyword("consume");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		String result = "";
		obj.changeHealth(-8);
		player.changeHealth(7);
		result = "You drank the " + obj.getName();
		if(obj.isAlive()) {
			result += ". There is still some left.";
		} else {
			result += ". There is none left.";
			obj.getLocation().removeFromInventory(obj);
		}
		r.setText(result);
		return r;
	}

}
