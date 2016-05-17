package org.vashonsd.pirateship.minigame.text;

public class PokeMove {

	private String name;
	private PokeType moveType;
	private int power;
	private int accuracy;
	private boolean continuous;
	private int healthGain;
	private int attackChange;
	private int defenseChange;
	private int speedChange;
	private int accuracyChange;
	
	public PokeMove(String name, String type, int power, int accuracy, boolean continuous, int healthGain, int attackChange, int defenseChange, int speedChange, int accuracyChange) 
	{
		this.name = name;
		this.moveType = new PokeType(type);
		this.power = power;
		this.accuracy = accuracy;
		this.continuous = continuous;
		this.healthGain = healthGain;
		this.attackChange = attackChange;
		this.defenseChange = defenseChange;
		this.speedChange = speedChange;
		this.accuracyChange = accuracyChange;
	}
	
	public String getName() {
		return name;
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
	public boolean isContinuous() {
		return continuous;
	}
	public int getHealthGain() {
		return healthGain;
	}
	public int getAttackChange() {
		return attackChange;
	}
	public int defenseChange() {
		return defenseChange;
	}
	public int speedChange() {
		return speedChange;
	}
	public int accuracyChange() {
		return accuracyChange;
	}
}
