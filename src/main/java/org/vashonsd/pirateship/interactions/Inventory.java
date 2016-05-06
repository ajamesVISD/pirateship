package org.vashonsd.pirateship.interactions;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Inventory {
	/** A dictionary connecting a key (String) to a Stack of Actors answering to that key. 
	 * 
	 * Example: The String "arrow" might retrieve a Stack of three Arrow objects.
	 * */
	protected HashMap<String, Stack<Actor>> inv;
	
	public Inventory() {
		inv = new HashMap<String, Stack<Actor>>();
	}
	
	public void addActor(Actor a) {
		String key = a.getName();
		if (!(inv.containsKey(key))) {
			inv.put(key, new Stack<Actor>());
		}
		inv.get(key).push(a);
	}
	
	public Actor getActor(String name) {
		if ((inv.containsKey(name)) && !(inv.get(name).isEmpty())) {
			return inv.get(name).pop();
		} else {
			return null;
		}
	}
	
	public String toString() {
		String result = "";
		Set<String> keylist = inv.keySet();
		for (String s : keylist) {
			Stack<Actor> actors = inv.get(s);
			if (actors.size() > 0) {
				if (actors.size() > 1) {
					result += actors.size() + " " + actors.peek().getTypeNamePlural();
				} else {
					result += actors.peek().getName();
				}
				result += "\n";
			}
		}
		return result;
	}
}
