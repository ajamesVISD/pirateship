package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.HashMap;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.minigame.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private DatabaseWriter db = new DatabaseWriter();
	
	private World thisWorld;
	
	private HashMap<String, Player> players;
	
	private Player player;
	private String quitWord = "exit";
	
	private LocationMiniRunner runner;
	
	public Game(String world) throws IOException {
		super();
    	//thisWorld = WorldBuilder.makeWorld(world);
    	thisWorld = WorldBuilder.makeWorldByFile(world);
		player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	players.put(player.getName(), player);
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();
	}
	
	public void Run() throws IOException {
		while(true) {
        	writer.write(player.getCurrentLocation().toString());
        	String command = getCommand();
        	evalCommand(command);
		}
	}
	
	/*
     * Gets the player's command, checking for valid/invalid input.
     */
    public String getCommand() throws IOException {
    	while(true) {
    		String command = reader.read();
    		if (command.equalsIgnoreCase(quitWord)) { quitGracefully(); };
    		if (player.getCurrentLocation().commandAvailable(command)) {
    			return command;
    		}
		writer.write("---Error 314---"
    		     + "\n" + center(command) + "\n" + 
					 "place not found");
    	}
    }
    
    private String center(String c)
    {
    	String center = "";
    	String see = c;
    	int dashes = (15 - c.length())/2;
    	for(int i = 0; i < dashes; i++)
    	{
    		center += "-";
    	}
    	see += center;
    	center += see;
    	if(c.length()%2 == 0)
    	center += "-";
    	if (c.length() > 15)
    	center = c;
    	return center;
    }
    
    public void evalCommand(String c) {
    	player.setCurrentLocation(player.getCurrentLocation().travel(c));
    }
    
    public void quitGracefully() throws IOException {
    	db.worldWriter(thisWorld);
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
    	System.exit(1);
    }
    
    public void playMinigame(Location place) throws IOException
    {
    	runner = new LocationMiniRunner(place.getGames());
    	
    	while(true)
    	{
    		String r = runner.Run(reader.read());
    		
    		if(r.equals("Thanks for playing! Goodbye."))
    		{
    			writer.write(r);
    			break;
    		} 
    		else
    		{
    			writer.write(r);
    		}
    	}
    }
}
