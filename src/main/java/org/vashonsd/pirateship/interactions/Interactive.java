package org.vashonsd.pirateship.interactions;

/*
 * The Interactive interface is satisfied by anything that can 
 * handle a Request object, returning a Response.
 * 
 * In practical terms, this will be nearly everything: Items, creatures, routes, players.
 * Think of anything that can be interacted with via player commands.
 * 
 */


public interface Interactive {
	/*
	 * This is where your command "goes"; that is, call the "handle" method with its command.
	 */
	public Response handle(Request r);
	
	/*
	 * This is where we get the official way to address this object. For now we will say that every
	 * Addressable needs to be able to report its own name. Even those with implied names will need
	 * (e.g., currentLocation) will need to provide one.
	 */
	public String getName();
}
