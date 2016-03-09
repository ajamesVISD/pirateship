package org.vashonsd.pirateship.minigame;

import java.util.Random;

public class TwentyQuestions implements Minigame {
	private int theNumber;
	private int guessesLeft;
	
	public TwentyQuestions() {
		super();
		setUpGame();
	}
	
	private void setUpGame() {
		Random rnd = new Random();
		theNumber = rnd.nextInt(1000) + 1;
		guessesLeft = 20;
	}

	public String Run() {
		return "I am thinking of a number from 1 to 1,000. What number do you guess?";
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
		} else if (g == theNumber) {
				setUpGame(); //With this game over, we reset the random in case the player wants to play again.
				return s + " is correct! I've already thought of another number...";
		}
		
		String response = "";
		//Now we know we have a valid number that is not the number. So:
		guessesLeft--;
		if (g < theNumber) {
			response = s + " is too low.";
		} else if (g > theNumber) {
			response = s + " is too high.";
		}
		
		//If we've run out of guesses, we announce the sad result and run the game again.
		//Otherwise, we tack on the number of guesses left.
		if (guessesLeft < 1) {
			setUpGame();
			response += "\nYou have run out of guesses! Let's play again.";
		} else {
			response += "\nYou have " + guessesLeft + " guesses left.";
		}
		return response;
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing, you mind reader you.";
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "20Q";
	}

}