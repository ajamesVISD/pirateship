package org.vashonsd.pirateship.minigame.text;

public class MinigameTwitterFactory implements TextMinigameFactory {

	public MinigameTwitterFactory() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return "Twitter";
	}

	public String getFullName() {
		return "Twitter news printer";
	}

	public String getDescription() {
		return "I'll print your latest tweets for you!";
	}

	public TextMinigame newGame() {
		return new MinigameTwitter();
	}

}
