package org.vashonsd.pirateship.commands;

import java.util.ArrayList;

public class CommandSets {
	
	public static ArrayList<Command> basic() {
		ArrayList<Command> results = new ArrayList<Command>();
		results.add(new Examine());
		results.add(new Take());
		return results;
	}
	
}
