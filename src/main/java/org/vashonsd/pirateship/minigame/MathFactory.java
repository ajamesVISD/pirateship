package org.vashonsd.pirateship.minigame;

public class MathFactory implements MinigameFactory {
	public String getName() {
		return "math";
	}
	
	public String getDescription() {
		return "Solve the math problem.";
	}
	
	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new MathGame();
	}
	
	public String getFullName() {
		return "Solve the math problem.";
	}
}
