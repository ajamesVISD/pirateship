package org.vashonsd.pirateship.minigame.text;

public class TwentyQuestionsFactory implements TextMinigameFactory {

	public String getName() {
		return "20Q";
	}

	public String getFullName() {
		return "Twenty Questions";
	}

	public String getDescription() {
		return "I'll pick a number between 1 and 1,000. You have 20 questions to guess it.";
	}

	public TextMinigame newGame() {
		return new TwentyQuestions();
	}

}
