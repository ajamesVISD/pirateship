package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;

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
	private EnumMap<VisibilityLevel, ArrayList<Actor>> availableActors;
	
	public AvailableInteractions() 
	{
		super();
		this.availableActors = new EnumMap<VisibilityLevel, ArrayList<Actor>>(VisibilityLevel.class);
		for (VisibilityLevel v : VisibilityLevel.values()) {
			availableActors.put(v, new ArrayList<Actor>());
		}
		this.addActor(new Always());
	}
	
	/**
	 * Steps through each HashMap per visibility level and parses them into one giant hash map, keyed to IDs.
	 * @return A HashMap of all Actors with which this Player can interact.
	 */
	public HashMap<String, Actor> getAllActors() {
		HashMap<String, Actor> result = new HashMap<String, Actor>();
		for (VisibilityLevel v : VisibilityLevel.values()) {
			//loop through the embedded HashMap, adding values to the result
			for (Actor a : availableActors.get(v)) {
				result.put(a.getId(), a);
			}
		}
		return result;
	}
	
	public HashMap<String, ArrayList<Actor>> getAllActorsByType() {
		HashMap<String, ArrayList<Actor>> result = new HashMap<String, ArrayList<Actor>>();
		//We loop through the HashMap keyed to VisibilityLevel values.
		for (VisibilityLevel v : VisibilityLevel.values()) {
			ArrayList<Actor> inner = availableActors.get(v);
			for (Actor a : inner) {
				ArrayList<String> ks = new ArrayList<String>();
				ks.add(a.getTypeName());
				//We might need to add the name as a key, too.
				if (a.getTypeName() != a.getName()) {
					ks.add(a.getName());
				}
				for (String k : ks) {
					if (!result.containsKey(k)) {
						result.put(k, new ArrayList<Actor>());
					}
					result.get(k).add(a);
				}
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
	private String[] parse(String s, HashMap<String, ArrayList<Actor>> responders) {
		String[] options = {s, s + " always"};
		for (String o : options) {
			String[] result = searchWith(o.split(" "), responders);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
	
	private String[] searchWith(String[] words, HashMap<String, ArrayList<Actor>> responders) {
		String[] res = new String[2];
		for (int i = 0; i < words.length; i++) {
			String directObject = String.join(" ", Arrays.copyOfRange(words, i, words.length));
			if (responders.containsKey(directObject)){
				res[0] = String.join(" ", Arrays.copyOfRange(words, 0, i));
				//res[0] = concat(Arrays.copyOfRange(words, 0, i));
				res[1] = directObject;
				return res;
			}
		}
		return null;
	}
	
	/*
	 * Calling handle() with the given request will dispatch the Request to the correct actor
	 * and return a Response. Along the way, side effects to the Player may occur.
	 * 
	 * We get the actors by keying to their typeName. This returns an array, possibly of only one member.
	 * If there are multiple entries in the array, we need some way of figuring this out.
	 */
	public Response handle(Request r)
	{
		HashMap<String, ArrayList<Actor>> responders = getAllActorsByType();
		//our example is "read book"
		//we split this to get "read" and "book"
		String[] parsed = parse(r.getText(), responders);
		if (parsed == null) {
			return new Response("I'm sorry, could you say that again?");
		}
		ArrayList<Actor> actors = responders.get(parsed[1]);
		Actor theThing;
		

		if (parsed[0].isEmpty()) {
			parsed[0] = "go";
		}
		
		if (actors.size() == 1) {
			theThing = actors.get(0);
		} else {
			Clarifier c = new Clarifier(parsed[0]);
			for (Actor a : actors) {
				c.addActors(a);
			}
			return c.clarify();
		}
		
		r.setVerb(parsed[0]);
		return theThing.handle(r);
	}
	
	public void addActor(Actor t) {
		//We place the Actor in its visibility level
		availableActors.get(t.getVisibility()).add(t);
	}
	
	/**
	 * Allows us to set the incoming actor at a given visibility level.
	 * @param t
	 * @param v
	 */
	public void addActor(Actor t, VisibilityLevel v) {
		availableActors.get(v).add(t);
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
		for (VisibilityLevel lev : availableActors.keySet()) {
			if (availableActors.get(lev).remove(t)) {
				break;
			}
		}
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
				result.addAll(availableActors.get(lev));
			}
		}
		return result;
	}
}