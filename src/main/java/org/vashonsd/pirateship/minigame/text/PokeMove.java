package org.vashonsd.pirateship.minigame.text;

public class PokeMove {

	private String name;
	private String description;
	private PokeType moveType;
	private int power;
	private int accuracy;
	private int healthGain;
	private int myAttackChange;
	private int attackChange;
	private int myDefenseChange;
	private int defenseChange;
	private int mySpeedChange;
	private int speedChange;
	private int myAccuracyChange;
	private int accuracyChange;
	
	public PokeMove(String name, String description, String type, int power, int accuracy, int healthGain, int myAttackChange, int attackChange, int myDefenseChange, int defenseChange, int mySpeedChange, int speedChange, int myAccuracyChange, int accuracyChange) 
	{
		this.name = name;
		this.description = description;
		this.moveType = new PokeType(type);
		this.power = power;
		this.accuracy = accuracy;
		this.healthGain = healthGain;
		this.myAttackChange = myAttackChange;
		this.attackChange = attackChange;
		this.myDefenseChange = myDefenseChange;
		this.defenseChange = defenseChange;
		this.mySpeedChange = mySpeedChange;
		this.speedChange = speedChange;
		this.myAccuracyChange = myAccuracyChange;
		this.accuracyChange = accuracyChange;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public PokeType getType() {
		return moveType;
	}
	public String getTypeName() {
		return moveType.getType();
	}
	public int getPower() {
		return power;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getHealthGain() {
		return healthGain;
	}
	public int getAttackChange() {
		return attackChange;
	}
	public int getDefenseChange() {
		return defenseChange;
	}
	public int getSpeedChange() {
		return speedChange;
	}
	public int getAccuracyChange() {
		return accuracyChange;
	}
	public int getMyAttackChange() {
		return myAttackChange;
	}
	public int getMyDefenseChange() {
		return myDefenseChange;
	}
	public int getMySpeedChange() {
		return mySpeedChange;
	}
	public int getMyAccuracyChange() {
		return myAccuracyChange;
	}

	public String toString() {
		return name + "\nType: "+ moveType.getType() + ". \"" + description + "\"\nPower: " + power + ". Accuracy: " + accuracy + "\n";
	}
}
