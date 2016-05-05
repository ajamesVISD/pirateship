package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.World;

/**
 * An interactive object keeps a dictionary of verbs and matching commands to handle those verbs.
 * It also specifies all the valid operations that can be performed on the interactive object itself.
 * This is crucial because the commands will need to know what methods can be called.
 * @author andy
 *
 */
public abstract class Actor {
	protected HashMap<String, Command> commands;
	
	//The inventory keeps a dictionary of objects, keyed by the object's name to a list of objects answering to that name.
	//If we have more than one object answering to that name, it can pop the last one from the list on a LIFO basis.
	protected HashMap<String, Stack<Actor>> inventory;
	
	protected Location currentLocation;
	protected World currentWorld;
	
	protected String description;
	
	protected String name;
	protected int health;
	protected int maxHealth;
	
	protected boolean alive;
	
	/**
	 * An Actor can handle commands and send commands to other Actors. It also keeps an inventory of items, has a current location,
	 * and has health. It is, by default, not alive. Override this setting to produce a creature.
	 * @param name
	 * @param description
	 */
	public Actor(String name, String description) {
		super();
		commands = new HashMap<String, Command>();
		inventory = new HashMap<String, Stack<Actor>>();
		this.description = description;
		this.name = name;
		//We begin by assuming that interactive objects are not alive.
		this.alive = false;
	}

	/**
	 * Use this method to enroll a Command with this object. 
	 * Commands come with their own ArrayList of accessors, for example: ["eat","devour","consume"].
	 * @param c - the Command you wish to enroll with this object.
	 */
	public void enrollCommand(Command c) {
		for (String s : c.getKeywords()) {
			commands.put(s, c);
		}
	}
	
	/**
	 * An overridden version of enrolling the command, allowing an alternate accessor than the one provided
	 * in the Command itself.
	 * @param c
	 * @param access -
	 */
	public void enrollCommand(Command c, String access) {
		commands.put(access, c);
	}

	/**
	 * The Actor receives a String for the predicate (or verb), and the Request object.
	 * It uses the HashMap to find the command matching the verb. If it finds nothing, it sends back an "I don't understand" response.
	 * If it finds a command, it calls the command's execute() methods, sending as parameters 
	 * the Actor itself, and the PlayerState from the request.
	 * @param verb -- the verb the parser has figured from the text command
	 * @param req -- the Request object
	 * @return A response to the request. Side effects to the object have already happened.
	 */
	public Response handle(String verb, Request req) {
		if (commands.containsKey(verb)) {
			return commands.get(verb).execute(this, req.getFrom());
		} else {
			return new Response("I don't know how to " + verb + " a " + this.name + ".");
		}
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public abstract void changeHealth(int n);
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void addToInventory(Actor i) {
		String key = i.getName();
		if (!(inventory.containsKey(key))) {
			inventory.put(key, new Stack<Actor>());
		}
		inventory.get(key).push(i);
	}
	
	public Actor getFromInventory(String name) {
		if ((inventory.containsKey(name)) && !(inventory.get(name).isEmpty())) {
			return inventory.get(name).pop();
		} else {
			return null;
		}
	}
	
	public Location getLocation() {
		return this.currentLocation;
	}
	
	public void setLocation(Location loc) {
		this.currentLocation = loc;
	}

	public HashMap<String, Stack<Actor>> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<String, Stack<Actor>> inventory) {
		this.inventory = inventory;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public World getCurrentWorld() {
		return currentWorld;
	}

	public void setCurrentWorld(World currentWorld) {
		this.currentWorld = currentWorld;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}
