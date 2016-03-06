package org.vashonsd.pirateship;

import java.util.ArrayList;

/**
 * @author andy
 * In this system, Locations are basically neutral entities. They have IDs, and persistent names.
 * Everything about a location that changes is kept in the LocationState object, which itself knows nothing
 * about the Location it may or may not be matched to.
 */
public class LocationState {
	//Commandables are commands available to the Player in this situation. It includes the massive list of
	//Commands available anywhere.
	private ArrayList<Commandable> commandables;
	
	//Processes are the minigames the Player can invoke to take over his/her I/O stream. The "main" process
	//is always available.
	private ArrayList<Process> processes;
	//	private ArrayList<Messages> messages;
	
	
}
