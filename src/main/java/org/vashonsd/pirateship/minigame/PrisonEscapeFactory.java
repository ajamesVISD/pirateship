package org.vashonsd.pirateship.minigame;

public class PrisonEscapeFactory implements MinigameFactory {

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

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new PrisonEscape();
	}

}
