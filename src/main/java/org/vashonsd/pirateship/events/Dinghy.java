package org.vashonsd.pirateship.events;

public class Dinghy extends Event {
	
	public Dinghy(String theName) {
		super(theName);
		setMydamage(new NoDamage());
	}

}
