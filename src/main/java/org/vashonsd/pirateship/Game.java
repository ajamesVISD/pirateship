package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;

public class Game {
	private HashMap<String, Player> players;
	
	private StatefulWorld thisWorld;
	
	private String quitWord = "exit";
	
	public Game(String world) {
		super();
		World w = WorldBuilder.makeWorld(world);
		players = new HashMap<String, Player>();
    	thisWorld = new StatefulWorld(w, w.getName());
	}
	
	/*
	 * This is the initializing function for a player beginning the game (or service, or what you will).
	 * The String it returns is the greeting phrase of the Main process.
	 */
	public String StartPlayer(String username) {
		//Create a new player.
		Player player = new Player(username);
		
		//Create an initial state for the new player.
    	PlayerState initState = new PlayerState(new MainProcess());
    	initState.setCurrentLocation(thisWorld.getStartingLocation());
    	initState.setIo(IOConfigFactory.consoleIO());
    	
    	player.setState(initState);
    	
//    	Now find our current game state, and update the hashmap to the new player and playerState.
    	players.put(username, player);
    	
    	//Give us whatever greeting the current process likes to say when waking up.
    	return initState.getCurrentProcess().greet();
	}
    
	/*
	 * Run is an endless loop that bootstraps the World for this player.
	 * Given the user's name, it logs that Player into the players array, takes them to the first World
	 * available, and generates the first Request.
	 * Only the magic word (set as the private variable quitWord) takes us out of the Game.
	 */
	public void Run(String user) throws IOException {
		//TODO: When we can persist players and their state, remove this to load both.
		String initString = StartPlayer(user);
		Player p = players.get(user);
		IOConfig io = p.getIo();
		io.write(initString);
//		TODO: This next line is a hack to get us our first location string. Later let the process handle it.
		io.write(p.getCurrentLocation().toString());
		while (true) {
			String input = io.read();
			System.out.println(input);
			if (input.equals(quitWord)) {
				io.write(p.getCurrentProcess().Exit());
				return;
			} else {
				Request r = new Request(p, input);
				Response resp = r.Handle();
				io.write(resp.getResponseText());
			}
		}
	}
}
