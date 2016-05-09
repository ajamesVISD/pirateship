package org.vashonsd.pirateship.minigame.text;

public class GuessingCalculatorFactory implements TextMinigameFactory {

	public String getName() {
		return "GuessCalc";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Guessing Calculator";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'll give you two whole numbers, and you tell me what their sum is.";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new GuessingCalculator();
	}

}
