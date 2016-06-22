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
		else if (s.equals("Littletown"))
		{
			return littleTown();
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
		gameRoom.addToInventory(new MinigameRunner("EscapeFactory"));
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

	
	public static World littleTown() {
		World w = new World("Littletown");
		boolean hasGem = false;
		Location square = new Location("Town square", "It's bustling with excitment.", "You are in the town square with shops and streets.");
		Location florist = new Location("Florist stand", "", "You are at a brightly colored forist's stand.\n\"Fresh flowers for sale!\"");
		Location baker = new Location("Baker's shop", "", "You are in a baker's shop, it smells delicious.\n\"Bread, bagels, and buns all right here.\"");
		Location clother = new Location("Tailorist", "", "You are in a dimmly lit tailor's shop.\n\"Clothes for everybody folks.\"");
		Location west = new Location("West Street", "", "You are in west street.\nA nice looking cobblestone road with houses lining it.");
		Location east = new Location("East Street", "", "You are in east street.\nA dirty dark alley.");
		Location south = new Location("South Street", "", "You are in south street.\nA clean wide street with the king's crest on banners.");
		Location north = new Location("North Street", "", "You are in north street.\nA clean, heavily guarded street.");
		
		square.addRoute("The florist's stand is bright with colors", "florist", "There is a florist's stand.", florist);
		square.addRoute("A warm aroma wafts from the bakery", "bakery", "There is a bakery.", baker);
		square.addRoute("The tailor is hard at work mending a green shirt", "tailor", "There is a tailor.", clother);
		square.addRoute("Neighbors talk and laugh in the street", "west", "West street", west);
		square.addRoute("Homeless people sleep in the street", "east", "East street", east);
		square.addRoute("Caravaners sell their foreign goods", "south", "South street", south);
		square.addRoute("Armored gaurds patrol the street", "north", "North street", north);
		square.addToInventory(CreatureFactory.newCreature("dog"));
		
		west.addRoute("Go back to the square", "square", "West Street", square);
		
		east.addRoute("Go back to the square", "square", "East street", square);
		east.addToInventory(new LWGemdealer());
		
		south.addRoute("Go back to the square", "square", "South street", square);
		
		north.addRoute("The gaurds force you to leave. \"King's orders\" they say.", "square", "North street", square);
		north.addToInventory(new LWGuard());
		
		florist.addRoute("Leave the florist's stand", "back", "Town square", square);
		baker.addRoute("Leave the bakery", "back", "Town square", square);
		clother.addRoute("Leave the tailorist's", "back", "Town square", square);	
		
		w.addLocation(square);
		w.addLocation(florist);
		w.addLocation(baker);
		w.addLocation(clother);
		w.addLocation(west);
		w.addLocation(east);
		w.addLocation(south);
		w.addLocation(north);
		
		w.setPointer(square);
		
		return w;
	}

}
