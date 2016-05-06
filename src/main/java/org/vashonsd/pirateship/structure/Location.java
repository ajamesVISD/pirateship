package org.vashonsd.pirateship.structure;

import java.util.*;

import org.vashonsd.pirateship.commands.TravelCommand;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.minigame.*;

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
	   super(name, description, splash);
	   this.name = name;
	   this.description = description;
	   this.setTraversable(true);
   }
	
	public void addRoute(String description, String accessor, String splash, Location dest) {
		Route r = new Route(this.getName() + "-" + dest.getName(), description, splash, dest, this);
		r.enrollCommand(new TravelCommand(accessor, dest));
		addToInventory(r);
	}
}
