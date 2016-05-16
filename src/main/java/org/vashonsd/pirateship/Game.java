package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.HashMap;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.minigame.*;
import org.vashonsd.pirateship.itemStuff.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private DatabaseWriter db = new DatabaseWriter();
	
	//Worlds act as namespaces. That is, two locations can have the same identifier as long as they exist in separate Worlds.
	private HashMap<String, World> worlds;
	
	//This is our register of current Players, each with a unique ID.
	private PlayerRegistry players;
	
	private World thisWorld;
	
	//private HashMap<String, Player> players;
	
	private String quitWord;
	
	public Game(String world) throws IOException {
		super();
		
		quitWord = "exit";

    	//thisWorld = WorldBuilder.makeWorldByFile(world);
		World thisWorld = WorldBuilder.makeWorld(world);
		
		this.players = new PlayerRegistry();
		Player p = new Player("Demo", "Just a player");
		p.setLocation(thisWorld.getStartingLocation());
		String pid = players.EnrollPlayer(p);
		
    	reader = new UserInput();
    	writer = new ConsoleOut();
	}
	
	public void Run() throws IOException {
		//For now we are just going to take the first Player off the registry.
		//Later we will want to be able to enroll players on the fly.
		Player p = players.get("Demo");
		writer.write(p.handle("look").getText() + "\n");
		while(true) {
        	String command = reader.read();
        	if (p.getTarget() == null && command.equals(quitWord)) {
        		break;
        	}
        	writer.write(p.handle(command).getText());;
		}
		writer.write("Thanks for playing!");
	}
}
