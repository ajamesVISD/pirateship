package org.vashonsd.pirateship.minigame;

public class CookieClickerFactory implements MinigameFactory {

	public String getName() {
		// TODO Auto-generated method stub
		return "CC";
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return "Cookie Clicker";
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "You click a cookie to gain cookies.";
	}

	public Minigame newGame() {
		// TODO Auto-generated method stub
		return new CookieClicker();
	}

}
