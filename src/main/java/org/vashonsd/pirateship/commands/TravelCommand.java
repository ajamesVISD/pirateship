package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.structure.Location;

public class TravelCommand extends Command {
	Location destination;
	
	public TravelCommand(String direction, Location destination) {
		addKeyword(direction);
		this.destination = destination;
	}
	
	@Override
	public Response execute(Actor obj, Actor from) {
		obj.setCurrentLocation(destination);
		return new Response(destination.getDescription());
	}

}
