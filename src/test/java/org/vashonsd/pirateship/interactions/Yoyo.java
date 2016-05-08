package org.vashonsd.pirateship.interactions;

public class Yoyo extends Actor {

	public Yoyo(String name, String description, String splash) {
		super(name, description, splash);
		this.enrollCommand(new Play());
	}

}
