package org.vashonsd.pirateship.structure;

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
			return BBSWorld();
		}
		else
		{
			return busyWorld();
		}
	}
	
	public static World busyWorld()
	{
		World w = new World("Busytown");
		Location main = new Location("City Hall", "You stand before a brick building with Greek gods painted on it");
		Location chat = new Location("City Hall Lobby", "Giant columns rise up 100 feet.");
		Location soft = new Location("Happy Park", "This happy place has birds singing, people playing.");
		Location news = new Location("Dead End Street", "This place is miserable.");
		
		main.addRoute("You see a heavy door with a brass handle", "open", chat, 3.1);
		main.addRoute("A gravel walkway leads to a park", "east", soft);
		main.addRoute("You can just barely spot a dark alley", "north", news);
		
		news.addRoute("You can return to City Hall", "south", main);
		soft.addRoute("The gravel walkway leads back to City Hall", "west", main);
		chat.addRoute("It's time to head back outside", "open", main);
		
		w.addLocation(main);
		w.addLocation(chat);
		w.addLocation(soft);
		w.addLocation(news);
		
		w.setPointer(main);
		
		return w;
	}
	
	public static World BBSWorld()
	{
		World w = new World("BBS");
		Location main = new Location("Main board", "Here you can view updates from the admins.");
		Location chat = new Location("Chat Room", "Start a conversation!");
		Location soft = new Location("Software Exchange", "Come get your shareware!");
		Location news = new Location("News room", "This place is miserable.");
		
		main.addRoute("Visit the chat room -->", "chat", chat);
		main.addRoute("Shareware library -->", "soft", soft);
		main.addRoute("Latest news", "news", news);
		
		news.addRoute("Back to the main board", "main", main);
		soft.addRoute("Back to the main board", "main", main);
		chat.addRoute("Back to the main board", "main", main);
		
		w.addLocation(main);
		w.addLocation(chat);
		w.addLocation(soft);
		w.addLocation(news);
		
		w.setPointer(main);
		
		return w;
	}
}
