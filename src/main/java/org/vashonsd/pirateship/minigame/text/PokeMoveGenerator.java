package org.vashonsd.pirateship.minigame.text;

public class PokeMoveGenerator {

	public PokeMoveGenerator(){}
	
	// moves need (name, type, power, accuracy, continuity, healthChange, myAttackChang, attackChange, myDefenseChange, defenseChange, mySpeedChange, speedChange, myAccuracyChange, accuracyChange)
	public PokeMove tackle() {
		PokeMove tackle = new PokeMove("Tackle", "normal", 35, 95, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		return tackle;
	}
	
}
