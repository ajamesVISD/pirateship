package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Take extends Command {
	
	public Take() {
		super();
		this.addKeyword("take");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		//Remove this object from the inventory of the object's parent.
		obj.getLocation().removeFromInventory(obj);
		//Put it in the inventory of the Player.
		player.addToInventory(obj);
		return new Response("You have taken " + obj.getName() + ".");
	}
}
