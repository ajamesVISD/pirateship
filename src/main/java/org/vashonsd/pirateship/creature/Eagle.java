package org.vashonsd.pirateship.creature;

public class Eagle extends Creature {

	public Eagle(String name) {
		super(name, "eagle", "It is an eagle with sharp talons", "An eagle soars above");
		this.setMaxHealth(50);
		this.setHealth(40);
		this.setTypeName("eagle");
		this.setTypeNamePlural("eagles");
	}
	

}
