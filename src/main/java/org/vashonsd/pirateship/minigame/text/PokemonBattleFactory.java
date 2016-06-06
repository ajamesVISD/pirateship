package org.vashonsd.pirateship.minigame.text;

public class PokemonBattleFactory implements TextMinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "Poke";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Pokemon Battle!";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Battle Pokemon";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new Battle();
	}

}
