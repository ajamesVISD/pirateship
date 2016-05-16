package org.vashonsd.pirateship.minigame.text;

public class PrisonEscapeFactory implements TextMinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "GOPP";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Get Out of Pig Prison";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Convice your pig warden to let you out of jail";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new PrisonEscape();
	}

}
