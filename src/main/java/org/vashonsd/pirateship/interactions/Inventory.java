package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Inventory {
	/** 
	 * A simple ArrayList of items. To group then in the manner of your choosing, write a method to group them.
	 **/
	protected ArrayList<Actor> inv;
	
	public Inventory() {
		inv = new ArrayList<Actor>();
	}
	
	public void addActor(Actor a) {
		inv.add(a);
	}
	
	public boolean hasActor(Actor a) {
		return (inv.contains(a));
	}
	
	public String toString() {
		String result = "";
		HashMap<String, Stack<Actor>> byType = new HashMap<String, Stack<Actor>>();
		for (Actor a : inv) {
			String type = a.getTypeName();
			byType.putIfAbsent(type, new Stack<Actor>());
			byType.get(type).push(a);
		}
		for (Stack<Actor> actors : byType.values()) {
			if (actors.size() > 1) {
				result += actors.size() + " " + actors.peek().getTypeNamePlural() + "\n";
			} else {
				result += actors.peek().getTypeName();
			}
		}
		return result;
	}
	
	public ArrayList<Actor> getAllItems(VisibilityLevel v) {
		ArrayList<Actor> result = new ArrayList<Actor>();
		for (Actor a : inv) {
			if (v.compareTo(a.getVisibility()) <= 0) {
				result.add(a);
			}
		}
		return result;
	}
	
	public ArrayList<Actor> getAllItems() {
		return this.getAllItems(VisibilityLevel.HELP);
	}
	
	public boolean remove(Actor a) {
		return inv.remove(a);
	}
}
