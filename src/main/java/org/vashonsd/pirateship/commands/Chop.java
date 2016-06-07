package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Apple;
import org.vashonsd.pirateship.interactions.Banana;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Chop extends Command {
	
	public Chop() {
		super();
		addKeyword("chop");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		String text = "";
		if (obj.isAlive() && player.getInventory().hasByTypeName("Axe")) {
			obj.changeHealth(-10);
			text += "You have damaged " + obj.getName() + " for 10 points.";
		} else if(obj.isAlive() && !(player.getInventory().hasByTypeName("Axe"))) {
			text += "How do you expect to chop down a tree if you don't have an axe?";
		}
		if (obj.isAlive()) {
			text += obj.getDescription();
		} else if(obj.getTypeName().equals("appleTree")){
			player.getLocation().addToInventory(new Apple());
			text += obj.getName() + " is not alive.";
		} else if(obj.getTypeName().equals("bananaTree")) {
			player.getLocation().addToInventory(new Banana());
			text += obj.getName() + " is not alive.";
		} else {
			text += obj.getName() + " is not something you can chop.";
		}
		r.setText(text);
		return r;
	}
	
}
