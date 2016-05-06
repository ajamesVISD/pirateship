package org.vashonsd.pirateship.interactions;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.World;

/**
 * An Actor is anything that can interact in the World.
 *
 * Actors have Locations, inventories, a list of commands by which they may be addressed (with the Actor as the direct object),
 * and a list of commands which may be invoked by the Actor.
 * @author andy
 *
 */
public abstract class Actor {
	protected HashMap<String, Command> commands;
	
	/**
	 * An object representing the commands which the Actor may invoke.
	 */
	protected AvailableInteractions interactions;
	
	/**
	 * An Inventory object keeps all the Actors within this Actor.
	 */
	protected Inventory inventory;
	
	protected Location currentLocation;
	protected World currentWorld;
	
	protected String description;
	
	protected String name;
	
	/**
	 * The typeName is the underlying type of thing: "sword" is the typeName for "rusty sword" and "magic sword of death."
	 * 
	 * The typeName should be set in the class extending Actor.
	 */
	protected String typeName;

	/**
	 * Helps with creating collections: e.g., "two knives", "four mice"
	 */
	protected String typeNamePlural;
	
	protected int health;
	protected int maxHealth;
	
	protected boolean alive = false;
	
	protected boolean traversable = false;
	protected boolean visible;

	/**
	 * An Actor can handle commands and send commands to other Actors. It also keeps an inventory of items, has a current location,
	 * and has health. It is, by default, not alive. Override this setting to produce a creature.
	 * @param name
	 * @param description
	 */
	public Actor(String name, String description) {
		super();
		commands = new HashMap<String, Command>();
		inventory = new Inventory();
		this.description = description;
		this.name = name;
	}

	public boolean isTraversable() {
		return traversable;
	}

	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}
	
	/**
	 * Use this command to rebuild the Actor's table of available interactions.
	 */
	public void Refresh() {
		//First we send the items in the inventory to be enrolled.
		
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
	 * Use this method to enroll more than one command at once, or an array of commands.
	 * @param commands
	 */
	public void enrollCommands(Command... commands) {
		for (Command c : commands) {
			enrollCommand(c);
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
			return new Response(defaultResponse(verb));
		}
	}
	
	protected String defaultResponse(String verb) {
		return "I don't know how to " + verb + " a " + this.name + ".";
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeNamePlural() {
		return typeNamePlural;
	}

	public void setTypeNamePlural(String typeNamePlural) {
		this.typeNamePlural = typeNamePlural;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	public void changeHealth(int n) {
		this.health += n;
		checkHealth();
	}
	
	protected void checkHealth() {
		if (health < 0) {
			setAlive(false);
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public void addToInventory(Actor a) {
		this.inventory.addActor(a);
	}
	
	public Actor getFromInventory(String name) {
		return this.inventory.getActor(name);
	}
	
	public Location getLocation() {
		return this.currentLocation;
	}
	
	public void setLocation(Location loc) {
		this.currentLocation = loc;
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
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
