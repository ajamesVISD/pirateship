package org.vashonsd.pirateship.minigame.text;

public class CrapsFactory implements TextMinigameFactory{

	public String getName() {
		return "craps";
	}

	public String getFullName() {
		return "Craps";
	}

	public String getDescription() {
		return "Roll some craps";
	}

	public TextMinigame newGame() {
		return new Craps();
	}

}
