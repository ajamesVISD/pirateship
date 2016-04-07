package org.vashonsd.pirateship;

import java.io.IOException;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.minigame.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private DatabaseWriter db = new DatabaseWriter();
	
	private World thisWorld;
	
	//private HashMap<String, Player> players;
	
	private Player player;
	
	private LocationMiniRunner runner;
	
	public Game(String world) throws IOException {
		super();

    	//thisWorld = WorldBuilder.makeWorld(world);
    	thisWorld = WorldBuilder.makeWorldByFile(world);
		player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	//players.put(player.getName(), player);
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();

	}
	
	public void Run() throws IOException {
		while(true) {
			writer.write(player.getCurrentLocation().toString());
			String[] s = evalCommand();
			handle(s);
		}
	}
	
	/*
     * Gets the player's command, checking for valid/invalid input.
     */
    
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
    
    public String[] evalCommand() throws IOException {
		String c = reader.read();
		c = c.toLowerCase();
		String[] one;		
		one = c.split(" ");
		return one;
	}
    
    public void handle(String[] array) throws IOException {
		int i = 0;
		if(array[i].equals("exit")) {
			quitGracefully();
		}
		else if(array[i].equals("go")) {
			i++;
			player.setCurrentLocation(player.getCurrentLocation().travel(array[i]));
		}
		else {
			String command = "";
			for(int a = 0; a < array.length; a++) {
				command+=array[a];
			}
			writer.write("---Error 314---"
	   			 + "\n" + center(command) + "\n" + 
   					 "place not found");
		}
	}
    
    public void evalCommand(String c) {
    	player.setCurrentLocation(player.getCurrentLocation().travel(c));
    }
    
    public void quitGracefully() throws IOException {
    	//db.worldWriter(thisWorld);
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
		writer.close();
		reader.close();
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
