package org.vashonsd.pirateship.structure;

import java.util.Random;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

/**
 * The Route class provides us with a connector towards a new Location.
 * Routes are one-way; to return from the new location to the old one, you need another route.
 * 
 */
public class Route extends Actor {
	
	//	The accessor is the word the user would type to travel through the route, e.g. "east"
	//TODO: for now, the accessor is part of the Route. Consider decoupling them, perhaps by turning the location
	//ArrayList into a HashMap with the accessor as the key.
	private Location destination;
	private String id;
	
	public Route(String name, String description, Location whereIs, Location dest) {
		super(name, description);
		this.currentLocation = whereIs;
		this.destination = dest;
		this.id = currentLocation.getName() + " - " + dest.getName();
		setTraversable(true);
	}

	public Location getDestination() {
		return destination;
	}
		
	public String getId() {
		return id;
	}

	
	public void setDestination(Location destination) {
		this.destination = destination;
	}

	@Override
	public void changeHealth(int n) {
		//Do nothing. It is impossible to change the health of a route.
	}
}
