package org.vashonsd.pirateship.structure;

import java.util.ArrayList;

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
	
	private ArrayList<Route> routes;

	public Location(String name, String description, String splash)
	{
	   super(name, "here", description, splash);
	   this.name = name;
	   this.description = description;
	   this.setTraversable(true);
	   this.routes = new ArrayList<Route>();
	}
	
	public void addRoute(String description, String accessor, String splash, Location dest) {
		Route r = new Route(accessor, description, splash, this, dest);
		r.enrollCommand(new TravelCommand(accessor, dest));
		addToInventory(r);
		routes.add(r);
	}
	

	public ArrayList<Route> getRoutes() {
		return routes;
	}
	
	public ArrayList<Location> getDestinations() {
		ArrayList<Location> destinations = new ArrayList<Location>();
		for (Route r : routes) {
			destinations.add(r.getDestination());
		}
		return destinations;
	}
	
	/**
	 * Use this method to add something to a Location. To add a Route, use the addRoute method.
	 * @param a
	 */
	public void addToLocation(Actor a) {
		this.addToInventory(a);
	}
	
	public void removeToLocation(Actor a)
	{
		this.removeFromInventory(a);
	}
}
