package org.vashonsd.pirateship.minigame;

public class BlackjackFactory implements MinigameFactory {

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

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new Blackjack();
	}

}
