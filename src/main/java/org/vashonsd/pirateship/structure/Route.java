package org.vashonsd.pirateship.structure;

import org.vashonsd.pirateship.commands.*;
import org.vashonsd.pirateship.interactions.Actor;

/**
 * The Route class provides us with a connector towards a new Location.
 * Routes are one-way; to return from the new location to the old one, you need another route.
 * 
 */
public class Route extends Actor {
	
	private Location destination;
	
	/**
	 * A Route is an actor with a destination. It uses that destination to enroll a Go command with that destination.
	 * 
	 * @param name The name of the route. This will be advertised to the user as [east], [up], etc.
	 * @param description If the user examines this route, user will see this text.
	 * @param splash The text displayed when the user enters the Location with this route in it.
	 * @param whereIs The "from" in the route.
	 * @param dest Where the route goes to.
	 */
	public Route(String name, String description, String splash, Location whereIs, Location dest) {
		super(name, name, description, splash);
		this.currentLocation = whereIs;
		this.destination = dest;
		this.id = currentLocation.getName() + " - " + dest.getName();
		this.enrollCommand(new Examine());
		this.enrollCommand(new Go(destination));
		setTraversable(true);
	}

	public Location getDestination() {
		return destination;
	}
	
	public void setDestination(Location destination) {
		this.destination = destination;
	}
}
