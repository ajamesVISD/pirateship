package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.vashonsd.pirateship.commands.Command;

/**
 * An Actor is anything that can interact in the World.
 *
 * Actors have Locations, inventories, a list of commands by which they may be addressed (with the Actor as the direct object),
 * and a list of commands which may be invoked by the Actor.
 * @author andy
 *
 */
public abstract class Actor {
	/**
	 * Represents all the commands that can be performed on this Actor.
	 * 
	 * Once a key (e.g., "examine" or "destroy") is used to find its matching Command, that command can have
	 * its handle() method called with this actor as a parameter.
	 */
	protected HashMap<String, Command> commands;
	
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
	
	public HashMap<String, Command> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, Command> commands) {
		this.commands = commands;
	}
	
	/**
	 * An Inventory object keeps all the Actors within this Actor.
	 */
	protected Inventory inventory;
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public void addToInventory(Actor a) {
		a.setLocation(this);
		this.inventory.addActor(a);
	}
	
	public boolean removeFromInventory(Actor a) {
		return this.inventory.remove(a);
	}
	
	/**
	 * Gets all items out of the inventory.
	 * @return
	 */
	public ArrayList<Actor> getAllItems() {
		return inventory.getAllItems();
	}
	
	/**
	 * Returns all items above a certain VisibilityLevel.
	 * @param v
	 * @return
	 */
	public ArrayList<Actor> getAllItems(VisibilityLevel v) {
		return inventory.getAllItems(v);
	}
	
	/**
	 * The current location of this Actor.
	 * 
	 * Notice that the Location is ... an actor. This means that orange seeds can be in an orange, a Player
	 * can be in a bed, and so on.
	 */
	protected Actor currentLocation;

	public Actor getLocation() {
		return currentLocation;
	}

	public void setLocation(Actor currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * The name, representing this Actor, which will be displayed.
	 */
	protected String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	/**
	 * A descriptive text for this Actor.
	 */
	protected String description;
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String s) {
		this.description = s;
	}
	
	/**
	 * The text that will be "splashed" when the Actor is encountered, or when the Player "look"s the Location.
	 */
	protected String splashText;
	
	public String getSplashText() {
		return splashText;
	}

	public void setSplashText(String splashText) {
		this.splashText = splashText;
	}

	/**
	 * It is very likely the game will need to refer to this entity by a unique identifier. Here it is.
	 */
	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * The typeName is the underlying type of thing: "sword" is the typeName for "rusty sword" and "magic sword of death."
	 * 
	 * The typeName should be set in the class extending Actor.
	 */
	protected String typeName;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	/**
	 * Helps with creating collections: e.g., "two knives", "four mice"
	 */
	protected String typeNamePlural;
	
	public String getTypeNamePlural() {
		return typeNamePlural;
	}

	public void setTypeNamePlural(String typeNamePlural) {
		this.typeNamePlural = typeNamePlural;
	}
	
	/**
	 * An integer representing the health of this Actor. Useful for some living creatures.
	 */
	protected int health;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * This is the proper way to change the health of the Actor, since it checks against maxHealth and 0.
	 * 
	 * If you want a dramatic death, override the setAlive() method to so something with a false value.
	 * @param n
	 */
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
	
	/**
	 * The maximum health of this Actor. 
	 * 
	 * Use getter and setter methods on health to be sure it does not go over this maximum.
	 */
	protected int maxHealth;
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	 * Actors are, by default, not alive. "Alive" is simply a boolean; make of it what you will.
	 */
	protected boolean alive = false;

	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Traversable objects can take us to another location. Again, another boolean for your use.
	 */
	protected boolean traversable = false;
	
	public boolean isTraversable() {
		return traversable;
	}

	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}
	
	/**
	 * An enum representing how visible an object in. Objects in plain sight are at EXAMINE.
	 * 
	 * As with many things, this is what you make of it. Until this is implemented, this is just four constants
	 * in a sequence.
	 */
	protected VisibilityLevel visibility = VisibilityLevel.EXAMINE;
	
	public VisibilityLevel getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityLevel visibility) {
		this.visibility = visibility;
	}

	/**
	 * An Actor can handle commands and send commands to other Actors. It also keeps an inventory of items, has a current location,
	 * and has health. It is, by default, not alive. Override this setting to produce a creature.
	 * @param name -- the short name of the Actor, e.g., "kitten"
	 * @param typeName -- the name of the underlying type of object. "Ruffles the kitten" is still a "kitten."
	 * @param description -- a description of the Actor, e.g., "the lustrous fur of this kitten entrances the eye"
	 * @param splash -- the text we get to announce the Actor, e.g., "You see a tiny kitten"
	 */
	public Actor(String name, String typeName, String description, String splash) {
		commands = new HashMap<String, Command>();
		inventory = new Inventory();
		this.description = description;
		this.splashText = splash;
		this.name = name;
		this.typeName = typeName;
		this.typeNamePlural = typeName + "s";
		this.id = UUID.randomUUID().toString();
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
	public Response handle(Request req) {
		String verb = req.getVerb();
		if (commands.containsKey(verb)) {
			return commands.get(verb).execute(this, req.getPlayer());
		} else {
			return handleOtherwise(req);
		}
	}
	
	/**
	 * If the request "falls through" the list of available commands, it makes its way here.
	 * The standard behavior is just to return a plain Request with a polite error message.
	 * Other Actors can override this method to provide deeply customized responses.
	 * @param req
	 * @return
	 */
	protected Response handleOtherwise(Request req) {
		return new Response("I don't know how to " + req.getVerb() + " a " + this.getTypeName() + ".");
	}
}
