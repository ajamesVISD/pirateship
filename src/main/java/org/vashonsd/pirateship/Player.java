package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;


/**
 * @author andy
 * The Player is really the keeper of state in this system.
 */
public class Player {
	private String name;
	private Location currentLocation;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
}
