package org.vashonsd.pirateship.minigame;

import java.util.Random;

public class TwentyQuestions implements Minigame {

	private int theNumber;
	
	public TwentyQuestions() {
		super();
		pickRandom();
	}
	
	private void pickRandom() {
		Random rnd = new Random();
		theNumber = rnd.nextInt(1000) + 1;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Twenty Questions";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "I'll pick a number between 1 and 1,000. You have 20 questions to guess it.";
	}

	public String Run() {
		// TODO Auto-generated method stub
		return "I am thinking of a number from 1 to 1,000. What number do you guess?";
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "20Q";
	}

	public String Request(String s) {
		// TODO Auto-generated method stub
		int g;
		try {
			g = Integer.parseInt(s);
		} catch (NumberFormatException err) {
			return "Sorry, you have to enter a number.";
		}
		if (!(g > 0 && g<1001)) {
			return "Your number has to be from 1 to 1,000.";
		} else if (g < theNumber) {
			return s + " is too low.";
		} else if (g > theNumber) {
			return s + " is too high.";
		} else {
			pickRandom(); //With this game over, we reset the random in case the player wants to play again.
			return s + " is correct! I've already thought of another number...";
		}
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing, you mind reader you.";
	}

}
