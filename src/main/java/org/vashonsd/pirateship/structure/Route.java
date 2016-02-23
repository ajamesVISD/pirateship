package org.vashonsd.pirateship.structure;

/**
 * The Route class provides us with a connector towards a new Location.
 * Routes are one-way; to return from the new location to the old one, you need another route.
 * 
 *
 */
public class Route{
	private String description;
	
//	The accessor is the word the user would type to travel through the route, e.g. "east"
	private String accessor;
	private Location destination;
	
	public Route(String description, String accessor, Location destination) {
		super();
		this.description = description;
		this.accessor = accessor;
		this.destination = destination;
	}
	
	public String getDescription() {
		return description + " [" + accessor + "]";
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getAccessor() {
		return accessor;
	}
	
}
