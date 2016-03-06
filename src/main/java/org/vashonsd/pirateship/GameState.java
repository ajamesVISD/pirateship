package org.vashonsd.pirateship;

import java.util.HashMap;

import org.vashonsd.pirateship.structure.Location;

public class GameState {
	private HashMap<Player, PlayerState> playerStates;
	private HashMap<Location, LocationState> locationStates;
	
	public void updatePlayerState(Player p, PlayerState ps) {
		playerStates.put(p, ps);
	}
	
	public PlayerState getPlayerState(Player p) {
		return playerStates.get(p);
	}
	
	public Location getPlayerLocation(Player p) {
		return playerStates.get(p).getCurrentLocation();
	}
	
	public void setPlayerLocation(Player p, Location l) {
		playerStates.get(p).setCurrentLocation(l);
	}
}
