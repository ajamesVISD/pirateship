package org.vashonsd.pirateship.minigame.text;

public class PokemonBattle implements TextMinigame {

	private boolean choseP;
	private boolean choseM;
	private Pokemon you;
	private Pokemon opponent;
	private PokeMoveGenerator gen;
	private boolean intro;
	
	public PokemonBattle() {
		setUp();
	}
	
	public String Run() {
		return "Wake up! You're gonna be late for your first day as a Pokemon trainer!\n\n";
	}
	
	public String getPrompt() {
		return "PB";
	}

	public String Handle(String s) 
	{
		if(intro = false)
		{
			intro = true;
			
			return getIntro();
		}
		
		return "byeBye";
	}

	public String Exit() {
		return "Your Pokemon journey has ended.";
	}

	public void hit(Pokemon source, Pokemon target, PokeMove move) 
	{
		source.changeHP(move.getHealthGain());
		target.changeHP((0-(((source.getAttack())/100)*(move.getPower()))*((100 - target.getDefense())/100))*move.getType().isEffective(target.getType()));
		source.changeAttack(move.getMyAttackChange());
		target.changeAttack(move.getAttackChange());
		source.changeDefense(move.getMyDefenseChange());
		target.changeDefense(move.getDefenseChange());
		source.changeSpeed(move.getMySpeedChange());
		target.changeSpeed(move.getSpeedChange());
		source.changeAccuracy(move.getMyAccuracyChange());
		target.changeAccuracy(move.getAccuracyChange());
	}
	
	public void setUp() 
	{
		choseP = false;
		choseM = false;
		/*
		you = new Pokemon("bulbasaur");
		you.addMove(gen.tackle());
		opponent = new Pokemon("bulbasaur");
		opponent.addMove(gen.tackle());
		*/
		
		intro = false;
	}
	
	public String getIntro()
	{
		Pokemon bulbasaur = new Pokemon("bulbasaur");
		Pokemon charmander = new Pokemon("charmander");
		Pokemon squirtle = new Pokemon("squirtle");
		String toReturn = "";
		toReturn += "Pick your pokemon: " + bulbasaur.toString() + "\n" + bulbasaur.printOut() +"\n"
			+ charmander.toString() + "\n" + charmander.printOut() +"\n" 
			+ squirtle.toString() + "\n" + squirtle.printOut() + "\n";
		
		return toReturn;
	}
}
