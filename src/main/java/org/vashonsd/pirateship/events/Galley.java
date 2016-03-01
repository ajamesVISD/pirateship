package org.vashonsd.pirateship.events;

public class Galley extends Event {
	
	public Galley(String theName) {
		super(theName);
		setMydamage(new MinorDamage());
	}

}
