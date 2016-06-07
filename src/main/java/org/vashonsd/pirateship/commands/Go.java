package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.structure.Location;

public class Go extends Command {

	Location loc;
	
	public Go(Location loc) {
		this.loc = loc;
		this.addKeywords("go", "travel", "walk");
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		player.setLocation(loc);
		return new Response(player.look());
	}

}
