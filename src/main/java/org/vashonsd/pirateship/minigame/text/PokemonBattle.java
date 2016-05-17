package org.vashonsd.pirateship.minigame.text;

public class PokemonBattle implements TextMinigame {

	private boolean choseP;
	private boolean choseM;
	private Pokemon yours;
	
	
	public String Run() {
		return "Wake up! You're gonna be late for your first day as a Pokemon trainer!";
	}

	
	
	public String getPrompt() {
		return "PB";
	}

	public String Handle(String s) {
		
		
		return null;
	}

	public String Exit() {
		return "Your Pokemon journey has ended.";
	}

}
