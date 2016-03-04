package org.vashonsd.pirateship.structure;

/**
 * The Route class provides us with a connector towards a new Location.
 * Routes are one-way; to return from the new location to the old one, you need another route.
 * 
 */
public class Route{
	private String description;
	
	//	The accessor is the word the user would type to travel through the route, e.g. "east"
	//TODO: for now, the accessor is part of the Route. Consider decoupling them, perhaps by turning the location
	//ArrayList into a HashMap with the accessor as the key.
	private String accessor;
	private double distance;
	private Location destination;
	
	public Route(String description, String accessor, Location destination) {
		super();
		this.distance = 0;
		this.description = description;
		this.accessor = accessor;
		this.destination = destination;
	}
	
	public Route(String description, String accessor, Location destination, double distance) {
		super();
		this.distance = distance;
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
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public String getAccessor() {
		return accessor;
	}
	
}
