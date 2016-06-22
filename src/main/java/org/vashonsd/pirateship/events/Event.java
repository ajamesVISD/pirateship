package org.vashonsd.pirateship.events;

public class Event {
	private String name;
	private int mydamage;
	
	public Event(String theName) {
		name = theName;
	}
	
	public String sayName() {
		return name;
	}
	
	public String sayDamage() {
		return getMydamage() + " damage delt to hull.";
	}

	public int getMydamage() {
		return mydamage;
	}

	public void setMydamage(int mydamage) {
		this.mydamage = mydamage;
	}

	@Override
	public String toString() {
		return name + ", " + mydamage + " damage delt to hull.";
	}
	
	
}
