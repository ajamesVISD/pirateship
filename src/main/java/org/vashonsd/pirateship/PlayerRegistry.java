package org.vashonsd.pirateship;

import java.util.HashMap;

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
	public void Add(String id, Player p) {
		this.registry.put(id, p);
	}
	
	public boolean Has(String id) {
		return registry.containsKey(id);
	}
}
