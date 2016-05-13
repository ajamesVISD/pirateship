package org.vashonsd.pirateship.minigame.text;

import java.util.*;

public class Pokemon 
{
	private String name;
	private String description;
	private PokeType type;
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private ArrayList<PokeMove> moves;
	private ArrayList<PokeMove> learnable;
	private String printOut;
	
	public Pokemon(String name)
	{
		this.name = name;
		moves = new ArrayList<PokeMove>();
		learnable = new ArrayList<PokeMove>();
		
		if(name.equalsIgnoreCase("charmander"))
			charmander();
		else if(name.equalsIgnoreCase("squirtle"))
			squirtle();
		else if(name.equalsIgnoreCase("bulbasaur"))
			bulbasaur();
	}
	
	public void addMove(PokeMove m)
	{
		moves.add(m);
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getHP() {
		return hp;
	}
	public int getAttack() {
		return attack;
	}
	
	public void charmander()
	{
		name = "Charmander";
		hp = 39;
		attack = 52;
		defense = 43;
		speed = 65;
		description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.";
	}
	
	public void squirtle()
	{
		name = "Squirtle";
		hp = 44;
		attack = 48;
		defense = 65;
		speed = 43;
		description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.";
	}
	
	public void bulbasaur()
	{
		name = "Bulbasaur";
		hp = 45;
		attack = 49;
		defense = 49;
		speed = 45;
		description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.";
	}
}
