package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Clarifier extends Actor {

	HashMap<String, Actor> options;
	/**
	 * A clarifier is used when more than one actor is the target of a command.
	 * @param name
	 * @param typeName
	 * @param description
	 * @param splash
	 */
	public Clarifier(String verb) {
		super("clarifier", UUID.randomUUID().toString(), "", "");
		options = new HashMap<String, Actor>();
		this.setVisibility(VisibilityLevel.NEVER);
	}
	
	/**
	 * This is a dinky implementation. Really, Clarifier should keep going back and forth with the user
	 * until the user finds the one in question, then sends along the verb to the Actor's handle method.
	 * @return
	 */
	public Response clarify() {
		String result = "Which one do you mean:\n";
		for (Actor a : options.values()) {
			result += a.getName() + "\n";
		}
		return new Response(result);
	}
	
	public void addActors(Actor a) {
		options.put(a.getName(), a);
	}
}
