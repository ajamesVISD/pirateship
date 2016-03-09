package org.vashonsd.pirateship.minigame;

import java.util.Random;

public class Shotgun implements Minigame {

	private int compAmmo;
	private int userAmmo;
	
	public Shotgun(){
		super();
		setUpGame();
	}
	
	private void setUpGame() {
		userAmmo = 0;
		compAmmo = 0;
	}

	public String Run() {
		// TODO Auto-generated method stub
		return "Reload, Dodge or Shoot. Make sure you have ammo.";
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Shot";
	}

	public String Request(String s) {
		// TODO Auto-generated method stub
		String request = "";
		Random rnd = new Random();
		int r = rnd.nextInt(3);
		if(s.equalsIgnoreCase("Shoot") && userAmmo == 0) {
			return "You don't have enough ammo to shoot, reload first.";
		}
		if(!(s.equalsIgnoreCase("Shoot") || s.equalsIgnoreCase("Reload") || s.equalsIgnoreCase("Dodge"))) {
			return "You can only dodge, reload, or shoot.";
		}
		if(r == 0) {
			request += "They reload, ";
			compAmmo++;
		}
		else if(r == 1) {
			request += "They dodge, ";
		}
		else {
			if(compAmmo == 0) {
				request += "They dodge, ";
			}
			else {
				request += "They shoot, ";
			}
		}
		if(s.equalsIgnoreCase("Reload")) {
			request += "you reload.";
		}
		else if(s.equalsIgnoreCase("Dodge")) {
			request += "you dodge.";
		}
		else {
			request += "you shoot.";
		}
		
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return null;
	}
}
