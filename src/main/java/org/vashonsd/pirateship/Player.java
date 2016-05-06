package org.vashonsd.pirateship;

import org.vashonsd.pirateship.interactions.Actor;


/**
 * @author andy
 * The Player represents a player in the game. Most of the state of the player is held in the PlayerState object, which can be
 * switched in an out as a component as needed.
 */
public class Player extends Actor {
	/**
	 * Pass a string for an id, a string for a name.
	 * @param id a unique identifier for this Player. Please look first in the PlayerRegistry to be sure this id is unique.
	 * @param name a name for the player. Does not have to be unique.
	 */
	public Player(String name, String description) {
		super(name, description);
	}
}
