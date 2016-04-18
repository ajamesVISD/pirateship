package org.vashonsd.pirateship.minigame;

public class GoFishFactory implements MinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "GF";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Go Fish";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Play a game of Go Fish against the computer.";
	}

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new GoFish();
	}

}