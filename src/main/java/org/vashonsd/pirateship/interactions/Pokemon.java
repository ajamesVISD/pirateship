package org.vashonsd.pirateship.interactions;

import java.util.ArrayList;

import org.vashonsd.pirateship.minigame.text.PokeMove;
import org.vashonsd.pirateship.minigame.text.PokeMoveGenerator;
import org.vashonsd.pirateship.minigame.text.PokeType;

public class Pokemon extends Actor {

	private String name;
	private String description;
	private PokeType type;
	private int hp;
	private int maxHP;
	private double attack;
	private double defense;
	private int speed;
	private ArrayList<PokeMove> moves;
	private ArrayList<PokeMove> learnable;
	private String printOut;
	private int accuracy;
	private ArrayList<String> head;
	
	public Pokemon(String name, String description)
	{
		super(name, "pokemon", description, "Poke!");
		this.name = name;
		this.description = description;
		moves = new ArrayList<PokeMove>();
		learnable = new ArrayList<PokeMove>();
		head = new ArrayList<String>();
	}
	
	public void addMove(PokeMove m) {
		moves.add(m);
	}
	public boolean knowsMove(PokeMove m) {
		return moves.contains(m);
	}
	public PokeMove getMove(String s) {
		for(PokeMove m: moves) {
			if(m.getName().equals(s))
				return m;
		}
		
		return null;
	}
	
	public String getTypeName() {
		return type.getType();
	}
	public void changeHP(double h) {
		hp += h;
		
		if(hp < 0)
			hp = 0;
		if(hp > maxHP)
			hp = maxHP;
	}
	public void changeAttack(int a) {
		attack += a;
	}
	public void changeDefense(int d) {
		defense += d;
	}
	public void changeSpeed(int s) {
		speed += s;
	}
	public void changeAccuracy(int a) {
		setAccuracy(getAccuracy() + a);
	}
	public String printMoves() {
		String toReturn = "";
		
		for(PokeMove m: moves) {
			toReturn += m.toString() + "\n";
		}
		
		return toReturn;
	}
	public boolean canLearn(PokeMove m) {
		return learnable.contains(m);
	}
	public String printHP() {
		String toReturn = "";
		for(int i=0; i<hp/5; i++) {
			toReturn += "+";
		}
		toReturn += hp;
		
		return toReturn;
	}
	public String toString() {
		return name + "\nHP: " + hp + " Attack: " + attack + " Defense: " + defense + " Speed: " + speed + "\n" + description + "\n";
	}
	public ArrayList<String> getHead() {
		return head;
	}
	public String printHead() {
		String toReturn = "";
		for(String s: head) {
			toReturn += s + "\n";
		}
		return toReturn;
	}
	
	public String battleHUD(Pokemon opp) {
		String toReturn = "";
		for(int i=0; i<hp/5; i++) {
			toReturn += "+";
		}
		toReturn += hp;
		for(int i=0; i<head.get(0).length(); i++) {
			toReturn += " ";
		}
		for(int i=0; i<opp.getHP()/5; i++) {
			toReturn += "+";
		}
		toReturn += opp.getHP() + "\n";
		for(int i=0; i<head.size(); i++) {
			toReturn += head.get(i) + "    " + opp.getHead().get(i) + "\n";
		}
		
		return toReturn;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}

	public String getPrintOut() {
		return printOut;
	}

	public void setPrintOut(String printOut) {
		this.printOut = printOut;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PokeType getType() {
		return type;
	}

	public void setType(PokeType type) {
		this.type = type;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<PokeMove> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<PokeMove> moves) {
		this.moves = moves;
	}

	public ArrayList<PokeMove> getLearnable() {
		return learnable;
	}

	public void setLearnable(ArrayList<PokeMove> learnable) {
		this.learnable = learnable;
	}

	public void setHead(ArrayList<String> head) {
		this.head = head;
	}
	
}
