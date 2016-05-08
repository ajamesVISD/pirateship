package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.Player;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Take extends Command {
	
	public Take() {
		super();
		this.addKeyword("take");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		//Remove this object from the inventory of the object's parent.
		Actor taken = obj.getLocation().removeFromInventory(obj);
		//Put it in the inventory of the Player.
		player.addToInventory(taken);
		return new Response("You have taken " + taken.getName() + ".");
	}
}
