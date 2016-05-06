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
	private HashMap<String, Location> locations;
	private String pointer; //This is the index of the starting location for this World.
	
	public World(String name) {
		super();
		this.setName(name);
		locations = new HashMap<String, Location>();
	}
	
	/**
	 * Checks for a unique ID for this Location.
	 * If the name is not unique, increments it until it is.
	 * @param loc
	 */
	public void addLocation(Location loc) {
		String name = loc.getName();
		String id = name;
		int incr = 0;
		while(locations.containsKey(id)) {
			incr++;
			id = name + Integer.toString(incr);
		}
		//Now we have a unique identifier.
		loc.setId(id);
		locations.put(id, loc);
	}
	
	public void addLocation(String name, String description, String splash) {
		Location l = new Location(name, description, splash);
		addLocation(l);
	}
	
	/*
	 * From the given Location, find the index of that Location and set the pointer to that.
	 * 
	 * Be sure it is enrolled first.
	 */
	public void setPointer(Location l) {
		pointer = l.getId();
	}
	
	/*
	 * Returns the first location
	 */
	public Location getStartingLocation() {
		return locations.get(pointer);
	}
	
	public void setStartingLocation(Location l) {
		setPointer(l);
	}
	
	public ArrayList<Location> getLocations() {
		ArrayList<Location> result = new ArrayList<Location>();
		for (String key : locations.keySet()) {
			result.add(locations.get(key));
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
