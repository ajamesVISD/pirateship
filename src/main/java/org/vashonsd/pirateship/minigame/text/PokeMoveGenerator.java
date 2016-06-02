package org.vashonsd.pirateship.minigame.text;

public class PokeMoveGenerator {

	public PokeMoveGenerator(){}
	
	// moves need (name, type, power, accuracy, healthChange, myAttackChang, attackChange, myDefenseChange, defenseChange, mySpeedChange, speedChange, myAccuracyChange, accuracyChange)
	public PokeMove tackle() {
		 return new PokeMove("Tackle", "A full-body charge attack.", "normal", 35, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove growl() {
		return new PokeMove("Growl", "A menacing growl that lowers your opponent's attack.", "normal", 0, 100, 0, 0, 6, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove vineWhip() {
		return new PokeMove("Vine Whip", "Whips the foe with slender vines.", "grass", 45, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove razorLeaf() {
		return new PokeMove("Razor Leaf", "The foe is hit with a cutting leaf.", "grass", 55, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove growth() {
		return new PokeMove("Growth", "The userâ€™s body is forced to grow, raising its attack.", "normal", 0, 100, 0, 6, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove tailWhip() {
		return new PokeMove("Tail Whip", "A strategic tail swipe that lowers your opponent's defense.", "normal", 0, 100, 0, 0, 0, 0, 6, 0, 0, 0, 0);
	}
	
	public PokeMove bubble() {
		return new PokeMove("Bubble", "A spray of bubbles hits the foe, lowering its speed.", "water", 20, 90, 0, 0, 0, 0, 0, 0, 6, 0, 0);
	}
	
	public PokeMove waterGun() {
		return new PokeMove("Water Gun", "The foe is blasted with a forceful shot of water.", "water", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove withdraw() {
		return new PokeMove("Withdraw", "Withdraws the body into its hard shell to raise defense.", "normal", 0, 100, 0, 0, 0, 6, 0, 0, 0, 0, 0);
	}
	
	public PokeMove scratch() {
		return new PokeMove("Scratch", "Scratches the foe with sharp claws.", "normal", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove ember() {
		return new PokeMove("Ember", "The foe is attacked with small flames.", "fire", 40, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public PokeMove rage() {
		return new PokeMove("Rage", "Deals damage and raises user's attack.", "normal", 20, 90, 0, 6, 0, 0, 0, 0, 0, 0, 0);
	}
}
