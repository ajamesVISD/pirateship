package org.vashonsd.pirateship.minigame;

public class ShotgunFactory implements MinigameFactory {

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

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new Shotgun();
	}
	

}
