package org.vashonsd.pirateship.structure;

import org.vashonsd.pirateship.commands.TravelCommand;
import org.vashonsd.pirateship.interactions.Actor;

/**
 * @author andy
 * A location represents a single place in our world.
 * 
 * Notice that a location does not "know" how you got there; it does not know what locations can get to it.
 * It can, through the routes list, figure out what destinations it can go to.
 */
public class Location extends Actor {

	public Location(String name, String description, String splash)
	{
	   super(name, "here", description, splash);
	   this.name = name;
	   this.description = description;
	   this.setTraversable(true);
	}
	
	public void addRoute(String description, String accessor, String splash, Location dest) {
		Route r = new Route(accessor, description, splash, this, dest);
		r.enrollCommand(new TravelCommand(accessor, dest));
		addToInventory(r);
	}
	
	/**
	 * Use this method to add something to a Location. To add a Route, use the addRoute method.
	 * @param a
	 */
	public void addToLocation(Actor a) {
		this.addToInventory(a);
	}
}
