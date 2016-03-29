package org.vashonsd.pirateship.structure;

import java.util.Random;

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
	private Location destination;
	private String id;
	private Random r = new Random();

	private String from;

	public Route(String description, String accessor, String from, Location destination) {
		super();
		this.description = description;
		this.accessor = accessor;
		this.from = from;
		this.destination = destination;
		this.id = from + " - " + destination.getName();
	}

	public Route(String id) {
		super();
		this.id = id;
	}
	
	public String getDescription() {
		return description + " [" + accessor + "]";
	}
	
	public String getDescriptionNA() {
		return description;
	}

	public Location getDestination() {
		return destination;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFrom() {
		return this.from;
	}
	
	public String getId() {
		return id;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setAccessor(String acc) {
		this.accessor = acc;
	}
	
	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getAccessor() {
		return accessor;
	}
	
}
