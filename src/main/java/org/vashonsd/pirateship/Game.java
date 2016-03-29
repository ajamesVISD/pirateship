package org.vashonsd.pirateship;

import java.io.IOException;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private DatabaseWriter db = new DatabaseWriter();
	
	private World thisWorld;
	
	private Player player;
	private String quitWord = "exit";
	
	public Game(String world) throws IOException {
		super();
    	//thisWorld = WorldBuilder.makeWorld(world);
    	thisWorld = WorldBuilder.makeWorldByFile(world);
		player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
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
    		if (command.equals(quitWord)) { quitGracefully(); };
    		if (player.getCurrentLocation().commandAvailable(command)) {
    			return command;
    		}
		writer.write("I'm sorry, I don't recognize " + command + "...");
    	}
    }
    
    public void evalCommand(String c) {
    	player.setCurrentLocation(player.getCurrentLocation().travel(c));
    }
    
    public void quitGracefully() throws IOException {
    	db.worldWriter(thisWorld);
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
    	System.exit(1);
    }
}
