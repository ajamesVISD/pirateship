package org.vashonsd.pirateship.structure;

/**
 * @author andy
 * This class creates an entire structure of connected locations and routes. It can do so
 * interactively, or it can load a preset from a file or database.
 * 
 * Eventually the WorldBuilder should allow a user to build a world which can be saved to a database.
 */
public class WorldBuilder {
	
	public static World testWorld()
	{
		World w = new World("Busytown");
		Location ch = new Location("City Hall", "You stand before a brick building with Greek gods painted on it");
		Location chinside = new Location("City Hall Lobby", "Giant columns rise up 100 feet.");
		Location hpark = new Location("Happy Park", "This happy place has birds singing, people playing.");
		Location des = new Location("Dead End Street", "This place is miserable.");
		
		ch.addRoute("You see a heavy door with a brass handle", "open", chinside);
		ch.addRoute("A gravel walkway leads to a park", "east", hpark);
		ch.addRoute("You can just barely spot a dark alley", "north", des);
		
		des.addRoute("You can return to City Hall", "south", ch);
		hpark.addRoute("The gravel walkway leads back to City Hall", "west", ch);
		chinside.addRoute("It's time to head back outside", "open", ch);
		
		w.addLocation(ch);
		w.addLocation(chinside);
		w.addLocation(hpark);
		w.addLocation(des);
		
		w.setPointer(ch);
		
		return w;
	}
}
