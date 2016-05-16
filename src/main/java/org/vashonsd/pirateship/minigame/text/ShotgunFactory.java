package org.vashonsd.pirateship.minigame.text;

public class ShotgunFactory implements TextMinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "Shot";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Shotgun";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Reload, Block, or Shoot, but time it right or you're dead";
	}

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new Shotgun();
	}
	

}
