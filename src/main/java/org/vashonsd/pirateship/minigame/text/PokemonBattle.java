package org.vashonsd.pirateship.minigame.text;

public class PokemonBattle implements TextMinigame {

	public String Run() {
		String toReturn = "";
		toReturn += "Wake up! You're gonna be late for your first day as a Pokemon trainer!";
		
		return toReturn;
	}

	public String getPrompt() {
		return "PB";
	}

	public String Handle(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public String Exit() {
		return "Your Pokemon journey has ended.";
	}

}
