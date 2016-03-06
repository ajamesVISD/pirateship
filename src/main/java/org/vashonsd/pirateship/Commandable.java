package org.vashonsd.pirateship;

public interface Commandable {
	
	/*
	 * Command is the way to execute the Commandable object. Some examples:
	 * Travel along a route, send a message, start a minigame.
	 */
	public String command();
	
	public String getAccessor();
	
	public String getDescription();
}
