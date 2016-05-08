package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;

import org.vashonsd.pirateship.commands.Command;

/**
 * The AvailableInteractions class is a managed HashMap of all the commands available to an Actor at a given moment.
 * 
 * The parsing of commands into verbs, and the finding of the correct Actors to respond to those verbs, happens here.
 * @author andy
 *
 */
public class AvailableInteractions 
{
	/**
	 * A map of available interactions, ordered by visibility, using the enum VisibilityLevel as a key.
	 * 
	 * Some commands are available but hidden (easter eggs). Some must always be displayed (routes, for example).
	 */
	private EnumMap<VisibilityLevel, HashMap<String,Actor>> availableActors;
	
	private HashMap<String, Actor> responders;
	
	public AvailableInteractions() 
	{
		super();
		this.availableActors = new EnumMap<VisibilityLevel, HashMap<String,Actor>>(VisibilityLevel.class);
		for (VisibilityLevel v : VisibilityLevel.values()) {
			availableActors.put(v, new HashMap<String, Actor>());
		}
		this.responders = new HashMap<String, Actor>();
		this.addActor(new Always());
	}
	
	/**
	 * Steps through each HashMap per visibility level and parses them into one giant hash map.
	 * @return A HashMap of all Actors with which this Player can interact.
	 */
	public HashMap<String, Actor> getAllActors() {
		HashMap<String, Actor> result = new HashMap<String, Actor>();
		for (VisibilityLevel v : VisibilityLevel.values()) {
			//loop through the embedded HashMap, adding values to the result
			HashMap<String, Actor> inner = availableActors.get(v);
			for (String s : inner.keySet()) {
				result.put(s, inner.get(s));
			}
		}
		return result;
	}

	/**
	 * For now, our grammar is very simple. All commands are in the imperative mood.
	 * See https://en.wikipedia.org/wiki/Imperative_mood if you like a lot of background.
	 * Commands are in the form "verb directObject", with the verb first (sorry, Yoda).
	 * Examples, with | as the dividing line:
	 * 
	 * read | book
	 * spit | watermelon seeds
	 * intimidate | the cowardly judge
	 * shake hands with | your worst enemy
	 * knock on | the red door
	 * knock on | the yellow door
	 * @param s — the string to be parsed
	 * 
	 */
	private String[] parse(String s) {
		String[] options = {s, s + " always"};
		for (String o : options) {
			String[] result = searchWith(o.split(" "));
			if (result != null) {
				return result;
			}
		}
		return null;
	}
	
	private String[] searchWith(String[] words) {
		String[] res = new String[2];
		for (int i = 0; i < words.length; i++) {
			String directObject = concat(Arrays.copyOfRange(words, i, words.length));
			if (responders.containsKey(directObject)){
				res[0] = concat(Arrays.copyOfRange(words, 0, i));
				res[1] = directObject;
				return res;
			}
		}
		return null;
	}
	
	private String concat(String[] arr) {
		String sep = "";
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res += sep + arr[i];
			sep = " ";
		}
		return res;
	}
	
	/*
	 * Calling handle() with the given request will dispatch the Request to the correct actor
	 * and return a Response. Along the way, side effects to the Player may occur.
	 */
	public Response handle(Request r)
	{
		responders = getAllActors();
		//our example is "read book"
		//we split this to get "read" and "book"
		String[] parsed = parse(r.getText());
		if (parsed == null) {
			return new Response("I'm sorry, could you say that again?");
		}
		
		Actor theThing = responders.get(parsed[1]);
		
		if (parsed[0].isEmpty()) {
			parsed[0] = "go";
		}
		r.setVerb(parsed[0]);
		return theThing.handle(r);
	}
	
	public void addActor(Actor t) {
		//We place the Actor in its visibility level
		availableActors.get(t.getVisibility()).put(t.getName(), t);
	}
	
	public void addActors(Actor... actors) {
		for (Actor a : actors) {
			addActor(a);
		}
	}
	
	public void Clear() {
		for (VisibilityLevel lev : availableActors.keySet()) {
			availableActors.get(lev).clear();
		}
	}
	
	public void removeActor(Actor t) {
		responders.remove(t.getName());
	}

	/**
	 * Returns all Actors at or above the given level of visibility.
	 * @param v
	 * @return
	 */
	public ArrayList<Actor> getActorsByVisibility(VisibilityLevel v) {
		ArrayList<Actor> result = new ArrayList<Actor>();
		for (VisibilityLevel lev : availableActors.keySet()) {
			if (lev.compareTo(v) >= 0) {
				result.addAll(availableActors.get(lev).values());
			}
		}
		return result;
	}
}