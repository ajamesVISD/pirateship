package org.vashonsd.pirateship.minigame;

public class TwentyQuestionsFactory implements MinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "20Q";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Twenty Questions";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'll pick a number between 1 and 1,000. You have 20 questions to guess it.";
	}

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new TwentyQuestions();
	}

}