package org.vashonsd.pirateship.commands;


import java.util.ArrayList;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.interactions.VisibilityLevel;

/**
 * A Command represents potential action to take, given an accessor word.
 * 
 * For instance, the "examine" command acts on a given object and returns its description. For this, the object
 * needs a public method for getting its description. We must rely on these public methods within the given object.
 * @author andy
 *
 */
public abstract class Command {
	protected ArrayList<String> keywords;
	protected boolean keepAlive = false;

	protected VisibilityLevel visibility;

	public Command() {
		keywords = new ArrayList<String>();
		visibility = VisibilityLevel.HELP;
	}

	/**
	 * 
	 * @param obj -- the Actor that is the target of this execution.
	 * @param player -- the Player that issued the command.
	 * @return -- a Response. Most crucial: swap in the new PlayerState, formulate a text response, and set the KeepAlive to true or false.
	 */
	public abstract Response execute(Actor obj, Player player);
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void addKeywords(String... keywords) {
		for (String k : keywords) {
			addKeyword(k);
		}
	}
	
	public void addKeyword(String s) {
		this.keywords.add(s);
	}

	public boolean isKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	public VisibilityLevel getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityLevel visibility) {
		this.visibility = visibility;
	}
	
}
