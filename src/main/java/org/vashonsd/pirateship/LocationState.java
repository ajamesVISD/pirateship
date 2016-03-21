package org.vashonsd.pirateship;

import java.util.ArrayList;

import org.vashonsd.pirateship.processes.Process;
import org.vashonsd.pirateship.processes.ProcessRegistry;

/**
 * @author andy
 * In this system, Locations are basically neutral entities. They have IDs, and persistent names.
 * Everything about a location that changes is kept in the LocationState object, which itself knows nothing
 * about the Location it may or may not be matched to.
 */
public class LocationState {
	//Commandables are commands available to the Player in this situation. It includes the massive list of
	//Commands available anywhere.
	private ProcessRegistry availableProcesses;
	
	
}
