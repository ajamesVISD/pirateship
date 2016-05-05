package org.vashonsd.pirateship.commands;


import java.util.ArrayList;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

/**
 * A Command represents potential action to take, given an accessor word.
 * 
 * For instance, the "examine" command acts on a given object and returns its description. For this, the object
 * needs a public method for getting its description. We must rely on these public methods within the given object.
 * @author andy
 *
 */
public abstract class Command {
	private ArrayList<String> keywords;
	
	public Command() {
		super();
		keywords = new ArrayList<String>();
	}

	/**
	 * 
	 * @param obj -- the Actor that is the target of this execution.
	 * @param from -- the Actor (usually the Player) that issued the command.
	 * @return -- a Response. Most crucial: swap in the new PlayerState, formulate a text response, and set the KeepAlive to true or false.
	 */
	public abstract Response execute(Actor obj, Actor from);
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void addKeyword(String s) {
		this.keywords.add(s);
	}
}
