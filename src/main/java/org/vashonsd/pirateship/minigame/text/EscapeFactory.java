package org.vashonsd.pirateship.minigame.text;


public class EscapeFactory implements TextMinigameFactory {

	public String getName() {
		return "escape";
	}

	public String getFullName() {
		return "Escape";
	}

	public String getDescription() {
		return "Try to escape the room.";
	}

	public TextMinigame newGame() {
		return new Escape();
	}

}
