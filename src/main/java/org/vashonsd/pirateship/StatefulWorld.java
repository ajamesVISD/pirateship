package org.vashonsd.pirateship;

import java.util.HashMap;

import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.World;

/*
 * This is a world that is "alive" -- that is, it is populated with all the States (LocationStates especially)
 * that reflect the changes in the World.
 */
public class StatefulWorld {
	private World w;
	
	//This HashMap gives us the present state of the world shared by the Players. If we insert a new LocationState
	//into this HashMap a new State is returned for that Location (provided we remember to check this dictionary
	//for the state).
	private HashMap<String, LocationState> worldState;
	
	private String name;

	public StatefulWorld(World w, String name) {
		super();
		this.w = w;
		this.worldState = worldState;
		this.name = name;
	}

	public Location getStartingLocation() {
		// TODO Auto-generated method stub
		return w.getStartingLocation();
	}
	
	public LocationState getLocationState(String key) {
		return worldState.get(key);
	}
	
	public void setLocationState(String key, LocationState ls) {
		worldState.put(key, ls);
	}
}
