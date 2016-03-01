package org.vashonsd.pirateship.events;

public class Breeze extends Event {
	
	public Breeze(String theName) {
		super(theName);
		setMydamage(new NoDamage());
	}

}
