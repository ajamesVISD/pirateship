package org.vashonsd.pirateship.minigame.text;

public class TicTacToeFactory implements TextMinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "TTT";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Tic Tac Toe";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Play tic tac toe against me, the computer. Don't worry, I'm not very good.";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new TicTacToe();
	}

}
