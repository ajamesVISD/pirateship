package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

/**
 * A 
 * @author andy
 *
 */
public abstract class Minigame extends Actor {
	
	Response response;

	public Minigame(String name, String typeName, String description, String splash) {
		super(name, typeName, description, splash);
		response = new Response();
		response.setKeepAlive(true);
		response.setTarget(this);
		response.setText(greet());
	}

	public abstract String greet();

	/**
	 * You get the keys to the handle method. Drive safely.
	 * 
	 * Use req.getVerb() to find out what action phrase has been sent to you.
	 * Use req.getPlayer() to get the player that made the request.
	 */
	@Override
	public abstract Response handle(Request req);
	
	public abstract String prompt();
	
	public abstract String exit();
}
