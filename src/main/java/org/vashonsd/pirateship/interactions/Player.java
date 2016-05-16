package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;

import org.vashonsd.pirateship.commands.Command;
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
	 * The object of the Player's attention. Null by default.
	 */
	Actor target;
	
	public Actor getTarget() {
		return target;
	}

	public void setTarget(Actor target) {
		this.target = target;
	}

	/**
	 * Pass a string for an id, a string for a name.
	 * @param id a unique identifier for this Player. Please look first in the PlayerRegistry to be sure this id is unique.
	 * @param name a name for the player. Does not have to be unique.
	 */
	public Player(String name, String description) {
		super(name, name, description, name + " is here!");
		interactions = new AvailableInteractions();
	}
	
	/** 
	 * Returns a view of the current environment, in the form of a string.
	 * By default, for any objects in the current environment (except the Player itself), return their splash text.
	 * Example: An eagle soars overhead.
	 * If the object is traversable (i.e., is a route to somewhere else), it pulls its name and adds it to the end in brackets.
	 * A winding staircase leads upward. [up]
	 * @return
	 */
	public String look() {
		refresh();
		String result = getLocation().getSplashText() + "\n";
		result += displayCommands(VisibilityLevel.EXAMINE);
		return result;
	}
	
	/**
	 * Rebuilds the interactions available to the Player.
	 * This is the big algorithm for figuring out all the commands available.
	 */
	public void refresh() {
		interactions.Clear();
		//Add all the actors that are above Help visibility in the Location's inventory.
		for (Actor a : this.getLocation().getAllItems()) {
			interactions.addActor(a);
		}
		//Add all the items in the inventory.
		for (Actor a : this.getAllItems()) {
			//Add the Actor at, at most, HELP level of visibility.
			if (a.getVisibility().compareTo(VisibilityLevel.HELP) >= 0) {
				interactions.addActor(a, VisibilityLevel.HELP);
			} else {
				interactions.addActor(a);
			}
		}
		//Add Mr. Always.
		interactions.addActor(new Always());
	}
	
	public Response handle(String text) {
		Request req = new Request(text, this);
		Response resp;
		if (this.target != null) {
			resp = this.target.handle(req);
		} else {
			refresh();
			resp = interactions.handle(req);
		}
		this.target = resp.getTarget();
		return resp;
	}

	public String displayCommands(VisibilityLevel v) {
		String result = "";
		for (Actor a : interactions.getActorsByVisibility(v)) {
			//We do not want to display ourselves.
			if (a != this) {
				result += a.getSplashText();
				ArrayList<String> prompts = new ArrayList<String>();
				for (Command c : a.getCommands().values()) {
					if (c.getVisibility().compareTo(v) >= 0) {
						prompts.addAll(c.getKeywords());
					}
				}
				if (a.isTraversable()) {
					prompts.add(a.getName());
				}
				if (prompts.size() > 0) {
					result += " [" + String.join(", ", prompts) + "]";
				}
				result += "\n";
			}
		}
		return result;
	}
}
