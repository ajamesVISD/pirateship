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
		else if (s.equals("BUSYWORLD"))
		{
			return busyWorld();
		}
		else
		{
			return littleTown();
		}
	}
	
	public static World busyWorld()
	{
		World w = new World("Busytown");
		Location main = new Location("City Hall", "You stand before a brick building with Greek gods painted on it");
		Location chat = new Location("City Hall Lobby", "Giant columns rise up 100 feet.");
		Location soft = new Location("Happy Park", "This happy place has birds singing, people playing.");
		Location news = new Location("Dead End Street", "This place is miserable.");
		
		main.addRoute("You see a heavy door with a brass handle", "open", chat);
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
	
	
	public static World littleTown() {
		World w = new World("Littletown");
		Location square = new Location("Town square", "It's bustling with excitment.");
		Location florist = new Location("Florist stand", "Fresh flowers for sale!");
		Location baker = new Location("Baker's shop", "Bread, bagels, and buns all right here.");
		Location clother = new Location("Tailorist", "Clothes for everybody folks.");
		Location west = new Location("West Street", "A nice looking cobblestone road with houses lining it.");
		Location houseJacob = new Location("Jacob's House", "A good sized oak door with a shining brass door handle.");
		Location houseJacobLocked = new Location("The door is locked tight", "Must not be home.");
		Location houseMary = new Location("Mary's House", "A small circular door with colorful painted designs.");
		Location houseMaryInside = new Location("Mary's house is very bright with colors", "Mary is sobbing in the corner.");
		Location houseMaryInsideTalk = new Location("She says through her tears", "My hampster died and i'm sad.");
		Location houseMaryInsideTalkNice = new Location("Her tears dry up", "She starts to smile.");
		Location houseMaryInsideTalkMean = new Location("She pushes you away", "You are forced to leave.");
		
		square.addRoute("The florist's stand is bright with colors", "florist", florist);
		square.addRoute("A warm aroma wafts from the bakery", "bakery", baker);
		square.addRoute("The tailor is hard at work mending a green shirt", "tailor", clother);
		square.addRoute("Neighbors talk and laugh in the street", "west", west);
		
		west.addRoute("Visit Jacob's house", "jacob", houseJacob);
		west.addRoute("Visit Mary's house", "mary", houseMary);
		west.addRoute("Go back to the square", "back", square);
		
		houseJacob.addRoute("Go inside", "open", houseJacobLocked);
		houseJacobLocked.addRoute("Leave", "back", west);
		
		houseMary.addRoute("Go inside", "open", houseMaryInside);
		houseMaryInside.addRoute("Talk to her", "talk", houseMaryInsideTalk);
		houseMaryInsideTalk.addRoute("Comfort her", "comfort", houseMaryInsideTalkNice);
		houseMaryInsideTalkNice.addRoute("Talk to her some more", "talk", houseMaryInsideTalk);
		houseMaryInsideTalkNice.addRoute("Leave", "leave", west);
		houseMaryInsideTalk.addRoute("Laugh in her face", "laugh", houseMaryInsideTalkMean);
		houseMaryInsideTalkMean.addRoute("Leave", "leave", west);
		houseMaryInside.addRoute("Leave", "back", west);
		
		florist.addRoute("Leave the florist's stand", "back", square);
		baker.addRoute("Leave the bakery", "back", square);
		clother.addRoute("Leave the tailorist's", "back", square);	
		
		w.addLocation(square);
		w.addLocation(florist);
		w.addLocation(baker);
		w.addLocation(clother);
		w.addLocation(west);
		w.addLocation(houseJacob);
		w.addLocation(houseJacobLocked);
		w.addLocation(houseMary);
		w.addLocation(houseMaryInside);
		w.addLocation(houseMaryInsideTalk);
		w.addLocation(houseMaryInsideTalkNice);
		w.addLocation(houseMaryInsideTalkMean);
		
		w.setPointer(square);
		
		return w;
	}
}
