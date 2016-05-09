package org.vashonsd.pirateship.minigame.text;

public class BlackjackFactory implements TextMinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "BlJ";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Blackjack";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Play a game of Blackjack";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new Blackjack();
	}

}
