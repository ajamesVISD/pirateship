package org.vashonsd.pirateship;

import org.vashonsd.pirateship.interactions.*;


/**
 * @author andy
 * The Player represents a player in the game. Most of the state of the player is held in the PlayerState object, which can be
 * switched in an out as a component as needed.
 */
public class Player extends Actor {
	
	/**
	 * An object representing the commands which the Actor may invoke.
	 */
	protected AvailableInteractions interactions;
	
	/**
	 * Pass a string for an id, a string for a name.
	 * @param id a unique identifier for this Player. Please look first in the PlayerRegistry to be sure this id is unique.
	 * @param name a name for the player. Does not have to be unique.
	 */
	public Player(String name, String description) {
		super(name, description, name + " is here!");
		interactions = new AvailableInteractions();
	}
	
	/**
	 * Rebuilds the interactions available to the Player.
	 * This is the big algorithm for figuring out all the commands available.
	 */
	public void refresh() {
		//Add all the actors that are above Help visibility in the Location's inventory.
		for (Actor a : this.getLocation().getAllItems()) {
			interactions.addActor(a);
		}
		//Add all the items in the inventory.
		for (Actor a : this.getAllItems()) {
			interactions.addActor(a);
		}
		//Add Mr. Always.
		interactions.addActor(new Always());
	}
	
	@Override
	public void addToInventory(Actor a) {
		super.addToInventory(a);
	}
	
	public Response handle(String text) {
		refresh();
		Request req = new Request(text);
		req.setFrom(this);
		return interactions.handle(req);
	}

	public String displayCommands(VisibilityLevel v) {
		String result = "";
		for (Actor a : interactions.getActorsByVisibility(v)) {
			result += a.getSplashText() + "\n";
		}
		return result;
	}
}
