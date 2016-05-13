package org.vashonsd.pirateship.commands;

public class CommandSets {
	
	public static Command[] basicForItems() {
		Command[] results = 
		{
		new Examine(), 
		new Take()
		};
		return results;
	}
	
}
