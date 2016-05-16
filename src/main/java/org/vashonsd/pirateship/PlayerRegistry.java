package org.vashonsd.pirateship;

import java.util.HashMap;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.structure.Location;

public class PlayerRegistry {
	private HashMap<String, Player> registry;

	public PlayerRegistry() {
		super();
		this.registry = new HashMap<String, Player>();
	}
	
	/**
	 * Use this 
	 * @param id -- the id of the player
	 * @param p -- the player object created for this player.
	 */
	public void add(String id, Player p) {
		this.registry.put(id, p);
	}
	
	public boolean has(String id) {
		return registry.containsKey(id);
	}
	
	public Player get(String id) {
		return registry.get(id);
	}
	
	/**
	 * Checks to see if the name is enrolled in the PlayerRegistry with its unique ID.
	 * If the given name does not represent a unique ID, it auto-generated a new unique ID by adding an integer
	 * value to the end of the name.
	 * @param name
	 * @return the id by which the player is registered.
	 */
	public String EnrollPlayer(Player p) {
		String id = p.getName();
		int incr = 0;
		while (this.has(id)) {
			incr++;
			id = p.getName() + String.valueOf(incr);
		}
		add(id, p);
		return id;
	}
}
