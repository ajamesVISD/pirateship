package org.vashonsd.pirateship.worldcreator;

import org.vashonsd.pirateship.io.StringRead;
import org.vashonsd.pirateship.io.StringWrite;
import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.World;

public class WorldCreator {

	private StringRead reader;
	private StringWrite writer;

	
	public World worldCreate() {
		
		writer.write("What is the name of your new world? ");
		World newWorld = new World(reader.read());
		
		writer.write("What is the name of the starting location? ");
		Location startingLocation = new Location(reader.read());
		
		newWorld.addLocation(startingLocation);
		newWorld.setPointer(startingLocation);
		
		
		
		while(true) {
			
			
			writer.write("Would you like to make a new location? ");
			if(reader.read().equalsIgnoreCase("no")) {
				break;
			}
			
			//TODO get all locations and get all routes and connect
			
			
		}
		
	}

	
}
