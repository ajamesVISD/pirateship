

package org.vashonsd.pirateship.minigame;

public class IqGeneratorFactory implements MinigameFactory {

	public String getName() {
		return "IQ";
	}
	
	public String getFullName() {
		return "IQ Generator";
	}
	
	public String getDescription() {
		return "I will generate your IQ and tell you how smart you are!";
	}
	
	public Minigame newGame() {
		return new IqGenerator();
	}
}
