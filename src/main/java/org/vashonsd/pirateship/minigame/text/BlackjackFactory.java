package org.vashonsd.pirateship.minigame.text;

public class BlackjackFactory implements TextMinigameFactory {

	public String getName() {
		return "BlJ";
	}

	public String getFullName() {
		return "Blackjack";
	}

	public String getDescription() {
		return "Play a game of Blackjack";
	}

	public TextMinigame newGame() {
		return new Blackjack();
	}

}
