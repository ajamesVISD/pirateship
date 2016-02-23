package org.vashonsd.pirateship.structure;

import java.util.*;
/**
 * @author andy
 * A World represents a collection of Locations. The connections among the Locations -- the Routes --
 * are stored within each Location; the World does know "know" anything about the routes. 
 * 
 * This class has all the basic methods for adding Locations and getting them; it does not include larger-scale
 * methods for building a World; for that, turn to the WorldBuilder class.
 */
public class World {
	private String name;
	private ArrayList<Location> locations;
	private int pointer; //This is the index of the starting location for this World.
	
	public World(String name) {
		super();
		this.setName(name);
		locations = new ArrayList<Location>();
	}
	
	public void addLocation(Location loc) {
		locations.add(loc);
	}
	
	public void addLocation(String name, String description) {
		Location l = new Location(name, description);
		locations.add(l);
	}
	
	/*
	 * From the given Location, find the index of that Location and set the pointer to that.
	 */
	public void setPointer(Location l) {
		pointer = locations.indexOf(l);
	}
	
	/*
	 * Returns the first location
	 */
	public Location getStartingLocation() {
		return locations.get(pointer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
