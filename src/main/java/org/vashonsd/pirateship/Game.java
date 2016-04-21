package org.vashonsd.pirateship;

import java.io.IOException;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.minigame.*;
import org.vashonsd.pirateship.itemStuff.*;

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
    	//thisWorld = WorldBuilder.makeWorldByFile(world);
		thisWorld = WorldBuilder.busyWorld();
		player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	//players.put(player.getName(), player);
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();

	}
	
	public void Run() throws IOException {
		String ave;
		String end;
		
		while(true) {
			
			if(player.getCurrentLocation().getGames().isEmpty() == false)
			{
				ave = "Available games: \n";
				end = "[Type 'play' then select a game]";
			}
			else
			{
				ave = "";
				end = "";
			}
			
			writer.write(player.getCurrentLocation().toString());
			writer.write(ave + player.getCurrentLocation().getGames().toString() + end);
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
		else if(array[i].equals("play"))
		{
			playMinigame(player.getCurrentLocation());
		}
		/*
		else if(array[i].equals("read"))
		{
			ArrayList<Item> availableBooks = new ArrayList<Item>();
			
			if(player.getCurrentLocation().getInventory().hasName(array[i+1]) || player.getInventory().hasName(array[i+1]))
			{
				
			}
			
		}
		*/
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
    	
    	writer.write(runner.printGreeting());
    	
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
