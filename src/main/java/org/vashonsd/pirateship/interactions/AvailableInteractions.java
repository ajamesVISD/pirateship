package org.vashonsd.pirateship.interactions;

import java.util.Arrays;
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
	private HashMap<String, Actor> responders;
	
	public AvailableInteractions() 
	{
		super();
		this.responders = new HashMap<String, Actor>();
	}

	/*
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
	 * 
	 */
	private String[] parse(String s) {
		String[] words = s.split(" ");
		String[] res = new String[2];
		//In cases of arrays of just one word, we insert the implied "go" as the verb.
		if (words.length == 1) {
			if (responders.containsKey(words[0])) {
				res[0] = "go";
				res[1] = words[0];
				return res;
			} else {
				return null;
			}
		}
		//We loop until we find a match
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
		//our example is "read book"
		//we split this to get "read" and "book"
		String[] parsed = parse(r.getText());
		if (parsed == null) {
			return new Response("I'm sorry, could you say that again?");
		}
		
		Actor theThing = responders.get(parsed[1]);
		
		r.setVerb(parsed[0]);
		return theThing.handle(parsed[0], r);
	}
	
	public void addActor(Actor t) {
		responders.put(t.getName(), t);
	}
	
	public void removeActor(Actor t) {
		responders.remove(t.getName());
	}
}