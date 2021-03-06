package org.vashonsd.pirateship.minigame.text;

import java.util.*;


public class Registry {
	// First we make an arraylist of Minigames, then we walk through each one, finding out its short name
	// and using that to enroll it in the hashmap.
	private HashMap<String, TextMinigameFactory> minigameMap;
	private ArrayList<TextMinigameFactory> minigames;

	public Registry() {
		super();
		minigames = new ArrayList<TextMinigameFactory>();
		minigameMap = new HashMap<String, TextMinigameFactory>();
		//enrollMinigames();
		createMap();
	}
	
	public boolean hasGame(String which) {
		return minigameMap.containsKey(which);
	}
	
	public void addGame(TextMinigameFactory toAdd)
	{
		minigames.add(toAdd);
		createMap();
	}
	
	public boolean isEmpty()
	{
		if(minigames.size() == 0)
			return true;
		
		return false;
	}
	
	/*
	 * PROGRAMMERS! This chunk of code is where we enroll minigames. Keep adding them here, and
	 * if you've set them up correctly, 
	 */
	
	/*
	private void enrollMinigames() {
		minigames.add(new TwentyQuestionsFactory());
		minigames.add(new CookieClickerFactory());
		minigames.add(new MathFactory());
		minigames.add(new GuessingCalculatorFactory());
		minigames.add(new TicTacToeFactory());
		minigames.add(new MinigameTwitterFactory());
		minigames.add(new ShotgunFactory());
		minigames.add(new PrisonEscapeFactory());
	}
	*/
	
	/*
	 * This method walks through the list of minigames, asking each for its name and using that
	 * name as the key in the basic map.
	 */
	private void createMap() {
		for (TextMinigameFactory m: minigames) {
			minigameMap.put(m.getName(), m);
		}
	}
	
	/*
	 * The point of all this: We get a playable TextMinigame by asking for it by its name.
	 */
	public TextMinigame getGame(String which) {
		if (minigameMap.containsKey(which)) {
			return minigameMap.get(which).newGame();
		} else {
			return null;
		}
	}
	
	public String toString() {
		String result = "";
		for (TextMinigameFactory m: minigameMap.values()) {
			result += m.getName() + ": " + m.getDescription() + "\n";
		}
		return result;
	}
}
