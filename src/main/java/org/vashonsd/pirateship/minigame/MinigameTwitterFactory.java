package org.vashonsd.pirateship.minigame;

public class MinigameTwitterFactory implements MinigameFactory {

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

	public Minigame newGame() {
		return new MinigameTwitter();
	}

}
