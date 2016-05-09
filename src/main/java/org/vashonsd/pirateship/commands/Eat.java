package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Eat extends Command {

	public Eat() {
		addKeywords("eat", "devour", "consume");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		String result = "";
		obj.changeHealth(-5);
		player.changeHealth(5);
		result = "You eat the " + obj.getTypeName();
		if (obj.isAlive()) {
			result += ". There is more to eat";
		} else {
			result += ". It's gone now.";
			obj.getLocation().removeFromInventory(obj);
		}
		r.setText(result);
		return r;
	}

}
