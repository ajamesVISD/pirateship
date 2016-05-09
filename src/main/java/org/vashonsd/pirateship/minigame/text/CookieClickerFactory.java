package org.vashonsd.pirateship.minigame.text;

public class CookieClickerFactory implements TextMinigameFactory {

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

	public TextMinigame newGame() {
		// TODO Auto-generated method stub
		return new CookieClicker();
	}

}
