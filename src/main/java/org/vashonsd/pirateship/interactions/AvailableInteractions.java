package org.vashonsd.pirateship.interactions;

import java.util.Arrays;
import java.util.HashMap;

public class AvailableInteractions 
{
	private HashMap<String, Interactive> responders;
	
	
	
	public AvailableInteractions() {
		super();
		this.responders = new HashMap<String, Interactive>();
	}

	/*
	 * For now, our grammar is very simple. All commands are in the imperative mood.
	 * See https://en.wikipedia.org/wiki/Imperative_mood if you like a lot of background.
	 * Commands are in the form "verb directObject", with the verb first (sorry, Yoda).
	 * Examples, with | as the dividing line:
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
	
	public Response handle(Request r)
	{
		//our example is "read book"
		//we split this to get "read" and "book"
		Response res = new Response("");
		String[] parsed = parse(r.getText());
		if (parsed == null) {
			res.setText("I'm sorry, could you say that again?");
			return res;
		}
		

		Interactive theThing = responders.get(parsed[1]);
		
		Request req = new Request(parsed[0]);
		return theThing.handle(req);
	}
	
	public void addInteractor(Interactive t) {
		responders.put(t.getName(), t);
	}
}