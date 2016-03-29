package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.*;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private World thisWorld;
	
	private Player player;
//	private String quitWord = "exit";
	
	public Game(String world) throws IOException {
		super();
    	thisWorld = WorldBuilder.makeWorld(world);
    	player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();
	}
	
	public void Run() throws IOException {
		while(true) {
        	writer.write(player.getCurrentLocation().toString());
        	//String command = getCommand();
        	String[] s = evalCommand();
        	handle(s);
		}
	}
	
	/*
     * Gets the player's command, checking for valid/invalid input.
     *
    public String getCommand() throws IOException {
    	String command = reader.read();
    	/*while(true) {
    		String command = reader.read();
    		if (command.equalsIgnoreCase(quitWord)) { quitGracefully(); };
    		if (player.getCurrentLocation().commandAvailable(command)) {
    			return command;
    		}
		writer.write("---Error 314---"
    		     + "\n" + center(command) + "\n" + 
					 "place not found");
    	}*
    	return command;
    }
    */
	
    private String center(String c) {
    	String center = "";
    	String see = c;
    	int dashes = (15 - c.length())/2;
    	for(int i = 0; i < dashes; i++) {
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
    	//player.setCurrentLocation(player.getCurrentLocation().travel(c));
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
    
    public void quitGracefully() throws IOException {
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
    	writer.close();
    	reader.close();
    	System.exit(1);
    }
}
