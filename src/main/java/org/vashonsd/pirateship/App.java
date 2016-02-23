package org.vashonsd.pirateship;

import java.io.*;

import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
	private static StringRead reader;
	private static StringWrite writer;
	
	private static World thisWorld;
	
	private static Player player;
	
	private static String quitWord = "exit";
	
    public static void main( String[] args ) throws IOException
    {
    	thisWorld = WorldBuilder.testWorld();
    	
    	player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();
    	
    	while(true) {
        	writer.write(player.getCurrentLocation().toString());
        	String command = getCommand();
        	evalCommand(command);
    	}
    }
    
    /*
     * Gets the player's command, checking for valid/invalid input.
     */
    public static String getCommand() throws IOException {
    	while(true) {
    		String command = reader.read();
    		if (command.equals(quitWord)) { quitGracefully(); };
    		if (player.getCurrentLocation().commandAvailable(command)) {
    			return command;
    		}
		writer.write("I'm sorry, I don't recognize " + command + "...");
    	}
    }
    
    public static void evalCommand(String c) {
    	player.setCurrentLocation(player.getCurrentLocation().travel(c));
    }
    
    public static void quitGracefully() throws IOException {
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
    	System.exit(1);
    }
}
