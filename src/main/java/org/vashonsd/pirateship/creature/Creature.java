package org.vashonsd.pirateship.creature;


public class Creature {
	
	protected String name;
	protected String description;
	protected int strength;
	
	public Creature(String name, String description, int strength) {
		this.name = name;
		this.description = description;
		this.strength = strength;
	}
	
	//getter method for name of creature
	public String getName() {
		return name;
	}
	
	//getter method for description of creature
	public String getDescription() {
		return description;
	}
	
	//getter method for strength of creature
	public int getStrength() {
		return strength;
	}
	
	//setter method for strength
	public void setStrength(int n) {
		strength = n;
	}
	
	
	public String toString() {
		return name + ": " + description;
	}
}
