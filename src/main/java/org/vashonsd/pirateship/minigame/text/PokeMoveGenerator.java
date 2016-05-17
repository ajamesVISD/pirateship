package org.vashonsd.pirateship.minigame.text;

public class PokeMoveGenerator {

	public PokeMoveGenerator(){}
	
	// moves need (name, type, power, accuracy, continuity, healthChange, attackChange, defenseChange, speedChange, accuracyChange)
	public PokeMove tackle() {
		PokeMove tackle = new PokeMove("Tackle", "normal", 35, 95, false, 0, 0, 0, 0, 0);
		return tackle;
	}
	
}
