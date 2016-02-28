package org.vashonsd.pirateship.minigame;

import java.util.*;

public class Registry {
	private ArrayList<String> minigames;

	public Registry() {
		super();
		this.minigames = new ArrayList<String>();
	}
	
	/*
	 * A public accessor to find out if the requested key really is in the registry.
	 */
	public boolean ContainsKey(String s) {
		return minigames.contains(s);
	}
	
	public Minigame MinigameFactory(String which) {
		if (which.equals("twenty")) {
			return new TwentyQuestions();
		} else {
			return null;
		}
	}
}