package org.vashonsd.pirateship.minigame.text;

public class MathFactory implements TextMinigameFactory {
	public String getName() {
		return "math";
	}
	
	public String getDescription() {
		return "Solve the math problem.";
	}
	
	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new MathGame();
	}
	
	public String getFullName() {
		return "Solve the math problem.";
	}
}
