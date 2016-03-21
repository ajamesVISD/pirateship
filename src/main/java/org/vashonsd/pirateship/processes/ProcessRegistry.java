package org.vashonsd.pirateship.processes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author andy
 * A process registry prepares a standard set of processes, along with a configuration for them.
 * In theory, one Game could have a different ProcessRegistry than another.
 */
public class ProcessRegistry {
	// We story the process factories in a dictionary. The key is the accessor name, the value
	// is the factory.
	private HashMap<String, AbstractProcessFactory> processFactories;
	
	public ProcessRegistry() {
		processFactories = new HashMap<String, AbstractProcessFactory>();
	}

	public HashMap<String, AbstractProcessFactory> getProcessFactoryList() {
		return processFactories;
	}
	
	public void AddFactory(AbstractProcessFactory pf) {
		processFactories.put(pf.getName(), pf);
	}
}
