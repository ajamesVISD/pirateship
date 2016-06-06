package org.vashonsd.pirateship.structure;

import java.io.IOException;

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
	
	/*
	public static World makeWorldByFile(String s) throws IOException {
		DatabaseParser dp = new DatabaseParser();
		return dp.parseWorld(s);
	}
	*/
	
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
		//main.addRoute("Enter the Casino", "casino", casino);
		
		news.addRoute("You can return to City Hall", "south", "City Hall is to the south", main);
		soft.addRoute("The gravel walkway leads back to City Hall", "west", "Head west to go back to City Hall", main);
		chat.addRoute("It looks nice out there", "outside", "You could go back outside", main);
		gameRoom.addRoute("It's the way back", "back", "You could go back to City Hall.", main);
		prison.addRoute("Escape!", "escape", "You must type \"escape\" to escape!",main);
		//casino.addRoute("Back to City Hall", "back", main);
		
		main.addToInventory(CreatureFactory.newCreature("eagle"));
		main.addToInventory(CreatureFactory.newCreature("lizard"));
		main.addToInventory(CreatureFactory.newCreature("dog"));
		main.addToInventory(new Bandage("bandage"));
		main.addToInventory(new Shades());
		main.addToInventory(new Medic());

		gameRoom.addToInventory(new MinigameRunner("20Q"));
		//gameRoom.addToInventory(new MinigameRunner("Blackjack"));
		gameRoom.addToInventory(new MinigameRunner("CC"));
		gameRoom.addToInventory(new MinigameRunner("GF"));
		gameRoom.addToInventory(new MinigameRunner("GuessCalc"));
		gameRoom.addToInventory(new MinigameRunner("math"));
		gameRoom.addToInventory(new MinigameRunner("GOPP"));
		gameRoom.addToInventory(new MinigameRunner("Shot"));
		gameRoom.addToInventory(new MinigameRunner("Tic tac toe"));
		gameRoom.addToInventory(new MinigameRunner("Twitter"));
		
		w.addLocation(main);
		w.addLocation(chat);
		w.addLocation(soft);
		w.addLocation(news);
		w.addLocation(gameRoom);
		w.addLocation(prison);
		
		w.setStartingLocation(main);
		
		return w;
	}
	
	/*
	public static World BBSWorld()
	{
		World w = new World("BBS");
		Location main = new Location("Main board", "Here you can view updates from the admins.");
		Location chat = new Location("Chat Room", "Start a conversation!");
		Location soft = new Location("Software Exchange", "Come get your shareware!");
		Location news = new Location("News room", "This place is miserable.");
		Location gameRoom = new Location("Game Room", "Play minigames!");
		
		main.addRoute("Visit the chat room -->", "chat", chat);
		main.addRoute("Shareware library -->", "soft", soft);
		main.addRoute("Latest news", "news", news);
		main.addRoute("Have fun in the Game Room", "games", gameRoom);
		
		news.addRoute("Back to the main board", "main", main);
		soft.addRoute("Back to the main board", "main", main);
		chat.addRoute("Back to the main board", "main", main);
		gameRoom.addRoute("Back to the main board", "main", main);
		
		w.addLocation(main);
		w.addLocation(chat);
		w.addLocation(soft);
		w.addLocation(news);
		w.addLocation(gameRoom);
		
//		gameRoom.addGame(new TwentyQuestionsFactory());
//		gameRoom.addGame(new CookieClickerFactory());
//		gameRoom.addGame(new MathFactory());
//		gameRoom.addGame(new GuessingCalculatorFactory());
//		gameRoom.addGame(new TicTacToeFactory());
//		gameRoom.addGame(new MinigameTwitterFactory());
//		gameRoom.addGame(new ShotgunFactory());
		
		w.setPointer(main);
		
//		gameRoom.addGame(new TwentyQuestionsFactory());
//		gameRoom.addGame(new CookieClickerFactory());
//		gameRoom.addGame(new MathFactory());
//		gameRoom.addGame(new GuessingCalculatorFactory());
//		gameRoom.addGame(new TicTacToeFactory());
//		gameRoom.addGame(new MinigameTwitterFactory());
//		gameRoom.addGame(new ShotgunFactory());
		
		return w;
	}
	*/

	/*
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
		
		square.addRoute("The florist's stand is bright with colors", "florist", "Town square", florist);
		square.addRoute("A warm aroma wafts from the bakery", "bakery", "Town square", baker);
		square.addRoute("The tailor is hard at work mending a green shirt", "tailor", "Town square", clother);
		square.addRoute("Neighbors talk and laugh in the street", "west", "Town square", west);
		
		west.addRoute("Visit Jacob's house", "jacob", "West Street", houseJacob);
		west.addRoute("Visit Mary's house", "mary", "West Street", houseMary);
		west.addRoute("Go back to the square", "back", "West Street", square);
		
		houseJacob.addRoute("Go inside", "open", "Jacob's House", houseJacobLocked);
		houseJacobLocked.addRoute("Leave", "back", "The door is locked tight", west);
		
		houseMary.addRoute("Go inside", "open", "Mary's House", houseMaryInside);
		houseMaryInside.addRoute("Talk to her", "talk", "Mary's house is very bright with colors", houseMaryInsideTalk);
		houseMaryInsideTalk.addRoute("Comfort her", "comfort", "She says through her tears", houseMaryInsideTalkNice);
		houseMaryInsideTalkNice.addRoute("Talk to her some more", "talk", "Her tears dry up", houseMaryInsideTalk);
		houseMaryInsideTalkNice.addRoute("Leave", "leave", "Her tears dry up", west);
		houseMaryInsideTalk.addRoute("Laugh in her face", "laugh", "She says through her tears", houseMaryInsideTalkMean);
		houseMaryInsideTalkMean.addRoute("Leave", "leave", "She pushes you away", west);
		houseMaryInside.addRoute("Leave", "back", "Mary's house is very bright with colors", west);
		
		florist.addRoute("Leave the florist's stand", "back", "Florist stand", square);
		baker.addRoute("Leave the bakery", "back", "Baker's shop", square);
		clother.addRoute("Leave the tailorist's", "back", "Tailorist", square);	
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
*/
}
