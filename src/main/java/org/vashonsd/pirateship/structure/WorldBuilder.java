package org.vashonsd.pirateship.structure;

import org.vashonsd.pirateship.creature.CreatureFactory;
import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.minigame.*;
import org.vashonsd.pirateship.minigame.text.MinigameTwitterFactory;

/**
 * @author andy 
 * This class creates an entire structure of connected locations and routes. It can do so
 * interactively, or it can load a preset from a file or database.
 * 
 * Eventually the WorldBuilder should allow a user to build a world which can be saved to a database.
 */

public class WorldBuilder {
	
	
	/*
	 * Consider this a very simple example of a Factory method; it makes a World based on a given String.
	 */
	public static World makeWorld(String s)
	{
		if (s.equals("BBS"))
		{
			//return BBSWorld();
			return null;
		}
		else if (s.equals("Busytown"))
		{
			return busyWorld();
		}
		else
		{
			return null;
		}
	}
	
	public static World busyWorld()
	{
		World w = new World("Busytown");
		Location main = new Location("City Hall", "It's a brick building", "You stand before a brick building with Greek gods painted on it");
		Location chat = new Location("City Hall Lobby", "Giant columns rise up 100 feet.", "You are in the City Hall Lobby. It is majestic.");
		Location soft = new Location("Happy Park", "This happy place has birds singing, people playing.", "Welcome to Happy Park! What a happy place.");
		Location news = new Location("Dead End Street", "This place is miserable.", "Uh oh! Dead end.");
		Location gameRoom = new Location("Game Room", "Play minigames!", "You are in the Game Room. Bells ring and machines whir.");
		Location prison = new Location("Pig Prison", "You done it now sonny", "It's Pig Prison, the worst place ever.");
		
		main.addRoute("This door has a brass handle. You could open it.", "open", "You see a heavy door with a brass handle", chat);
		main.addRoute("You can see a park off to the east", "east", "A gravel walkway leads east",soft);
		main.addRoute("You can't see very far into the alley", "north", "A dark alley leads to the north", news);
		main.addRoute("The sign says type \"games\" for some games!", "games", "A sign says type \"games\" for some games!", gameRoom);
		main.addRoute("Go straight to jail", "prison", "You can also go to prison if you want.", prison);
		
		news.addRoute("You can return to City Hall", "south", "City Hall is to the south", main);
		soft.addRoute("The gravel walkway leads back to City Hall", "west", "Head west to go back to City Hall", main);
		chat.addRoute("It looks nice out there", "outside", "You could go back outside", main);
		gameRoom.addRoute("It's the way back", "back", "You could go back to City Hall.", main);
		prison.addRoute("Escape!", "escape", "You must type \"escape\" to escape!",main);
		
		main.addToInventory(CreatureFactory.newCreature("eagle"));
		main.addToInventory(new StopWatch("stopwatch"));
		main.addToInventory(CreatureFactory.newCreature("lizard"));
		main.addToInventory(CreatureFactory.newCreature("dog"));
		main.addToInventory(new Bandage("bandage"));
		main.addToInventory(new Medic());

		gameRoom.addToInventory(new MinigameRunner("20Q"));
		gameRoom.addToInventory(new MinigameRunner("CC"));
		gameRoom.addToInventory(new MinigameRunner("GF"));
		gameRoom.addToInventory(new MinigameRunner("GuessCalc"));
		gameRoom.addToInventory(new MinigameRunner("math"));
		gameRoom.addToInventory(new MinigameRunner("GOPP"));
		gameRoom.addToInventory(new MinigameRunner("Shot"));
		gameRoom.addToInventory(new MinigameRunner("TTT"));
		
		w.addLocation(main);
		w.addLocation(chat);
		w.addLocation(soft);
		w.addLocation(news);
		w.addLocation(gameRoom);
		w.addLocation(prison);
		
		w.setStartingLocation(main);
		
		return w;
	}
}
