package org.vashonsd.pirateship.minigame;

public class TicTacToeFactory implements MinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "Tic Tac Toe";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Tic Tac Toe";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Play tic tac toe against me, the computer. Don't worry, I'm not very good.";
	}

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new TicTacToe();
	}

}
