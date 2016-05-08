package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.Player;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.interactions.VisibilityLevel;
import org.vashonsd.pirateship.structure.Location;

public class TravelCommand extends Command {
	Location destination;
	
	/**
	 * Supply makes a new TravelCommand with a direction and a destination
	 * @param direction
	 * @param destination
	 */
	public TravelCommand(String direction, Location destination) {
		super();
		addKeyword(direction);
		this.destination = destination;
		this.setVisibility(VisibilityLevel.HELP);
	}
	
	@Override
	public Response execute(Actor obj, Player from) {
		from.setLocation(destination);
		return new Response(destination.getDescription());
	}
}
