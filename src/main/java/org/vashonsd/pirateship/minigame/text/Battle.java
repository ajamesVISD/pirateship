package org.vashonsd.pirateship.minigame.text;
import java.util.*;

import org.vashonsd.pirateship.interactions.poke.PokeMove;
import org.vashonsd.pirateship.interactions.poke.PokeMoveGenerator;

public class Battle implements TextMinigame {

	private boolean choseP;
	private boolean choseM;
	private MiniPokemon you;
	private MiniPokemon opponent;
	private PokeMoveGenerator gen;
	private boolean intro;
	private ArrayList<MiniPokemon> availablePokemon;
	
	public Battle() {
		choseP = false;
		choseM = false;
		intro = false;
		availablePokemon = new ArrayList<MiniPokemon>();
		gen = new PokeMoveGenerator();
		
		availablePokemon.add(new MiniPokemon("bulbasaur"));
		availablePokemon.add(new MiniPokemon("charmander"));
		availablePokemon.add(new MiniPokemon("squirtle"));
	}
	
	public String Run() {
		return "Wake up! You're gonna be late for your first day as a Pokemon trainer!";
	}
	
	public String getPrompt() {
		return "Poke";
	}

	public String Handle(String s) 
	{
		boolean hasMove = false;
		
		if(intro == false) {
			intro = true;
			return getIntro();
		}
		if(choseP == false) {
			if(s.equalsIgnoreCase("yes")) {
				choseP = true;
				int which = Randomizer.nextInt(2);
				
				if(which == 0) {
					opponent = new MiniPokemon("squirtle");
					opponent.addMove(gen.tackle());
					opponent.addMove(gen.waterGun());
					opponent.addMove(gen.withdraw());
					opponent.addMove(gen.tailWhip());
				} 
				else if(which == 1) {
					opponent = new MiniPokemon("charmander");
					opponent.addMove(gen.scratch());
					opponent.addMove(gen.ember());
					opponent.addMove(gen.rage());
					opponent.addMove(gen.tailWhip());
				}
				else if(which == 2) {
					opponent = new MiniPokemon("bulbasaur");
					opponent.addMove(gen.tackle());
					opponent.addMove(gen.razorLeaf());
					opponent.addMove(gen.growth());
					opponent.addMove(gen.growl());
				}
				
				return "You have chosen " + you.getName() + "\nWhat moves should your pokemon learn (4 max)\n" + learnableMoves(you);
			}
			else if (s.equalsIgnoreCase("no")) {
				return getIntro();
			}
			for(MiniPokemon m: availablePokemon) {
				if(s.equalsIgnoreCase(m.getName())) {
					you = m;
					return m.toString() + m.printOut() + "\nWould you like " + m.getName() + " the " + m.getTypeName() + " pokemon?";
				}
			}
			
			return "You must chose a pokemon from the list.";
		}
		
		if(choseM == false) {
			if(you.getMoves().size() == 4) {
				choseM = true;
				return "Your Pokemon is ready to battle!\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves();
			}
			for(PokeMove m: you.getLearnable()) {
				if(s.equalsIgnoreCase(m.getName())) {
					you.addMove(m);
					if(you.getMoves().size() < 4) {
						return "Your Pokemon learned " + m.getName() + "\n" + you.getName() + "'s moves: \n" + you.printMoves() + "\n\nSelect another move. " + learnableMoves(you) + "\n";
					} else {
						return "Your Pokemon learned " + m.getName() + "\n" + you.getName() + "'s moves: \n" + you.printMoves();
					}
				}
			}
			
			return "You must select a move from the list.\n" + learnableMoves(you);
		}
		
		if(!you.isDead() && !opponent.isDead())
		{
			int youAcc = Randomizer.nextInt(100);
			int oppAcc = Randomizer.nextInt(100);
			PokeMove oppMove = opponent.getMoves().get(Randomizer.nextInt(3));
			String toReturn = "";
			
			if(yourMove()) {
				for(PokeMove m: you.getMoves()) {
					
					if(s.equalsIgnoreCase(m.getName())) {
						hasMove = true;
						
						if(willHit(m, youAcc)) {
							hit(you, opponent, m);
							toReturn += "You used " + m.getName() + m.getType().effString(opponent.getType()) + "\n";
						} else {
							toReturn += "You used " + m.getName() + " it missed.\n";
						}
						
						break;
					}
				}
				
				if(hasMove == false) {
					return "You must chose a valid move.";
				}
				if(you.isDead() || opponent.isDead()) {
					return you.battleHUD(opponent) + getWinner().getName() + " wins.";
				}
				
					if(willHit(oppMove, oppAcc)) {
						hit(opponent, you, oppMove);
						toReturn += "Opponent used " + oppMove.getName() + oppMove.getType().effString(you.getType()) + "\n";
					} else {
						toReturn += "Opponent used " + oppMove.getName() + " it missed.\n";
					}
				}
				else if(!yourMove()) {
					if(willHit(oppMove, oppAcc)) {
						hit(opponent, you, oppMove);
						toReturn += "Opponent used " + oppMove.getName() + oppMove.getType().effString(you.getType()) + "\n";
					} else {
						toReturn += "Opponent used " + oppMove.getName() + " it missed.\n";
					}
					
					if(you.isDead() || opponent.isDead()) {
						return getWinner().getName() + " wins.";
					}
					
					for(PokeMove m: you.getMoves()) {
						
						if(s.equalsIgnoreCase(m.getName())) {
							hasMove = true;
							
							if(willHit(m, youAcc)) {
								hit(you, opponent, m);
								toReturn += "You used " + m.getName() + m.getType().effString(opponent.getType()) + "\n";
							} else {
								toReturn += "You used " + m.getName() + " it missed.\n";
							}
							
							break;
						}
				}
				
					if(hasMove == false) {
						return "You must chose a valid move.";
					}
			}
			
			return toReturn + "\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves();
		}
		
		return you.battleHUD(opponent) + getWinner().getName() + " wins.";
	}

	public String Exit() {
		return "Your Pokemon journey has ended.";
	}

	public void hit(MiniPokemon source, MiniPokemon target, PokeMove move) 
	{
		source.changeHP(move.getHealthGain());
		target.changeHP((-(((source.getAttack())/100)*(move.getPower()))*((100 - target.getDefense())/100))*move.getType().isEffective(target.getType()));
		source.changeAttack(move.getMyAttackChange());
		target.changeAttack(move.getAttackChange());
		source.changeDefense(move.getMyDefenseChange());
		target.changeDefense(move.getDefenseChange());
		source.changeSpeed(move.getMySpeedChange());
		target.changeSpeed(move.getSpeedChange());
		source.changeAccuracy(move.getMyAccuracyChange());
		target.changeAccuracy(move.getAccuracyChange());
	}
	
	public String getIntro()
	{
		String toReturn = "Select a Pokemon: \n";
		for(MiniPokemon m: availablePokemon) {
			toReturn += m.getName() + "\n";
		}
		return toReturn;
	}
	
	public String learnableMoves(MiniPokemon s) {
		String toReturn = "Available moves:\n";
		for(PokeMove m: s.getLearnable()) {
			toReturn += m.toString() + "\n";
		}
		return toReturn;
	}
	
	public boolean yourMove() {
		return you.getSpeed() >= opponent.getSpeed();
	}
	
	public MiniPokemon getWinner() {
		if(you.isDead())
			return opponent;
		
		return you;
	}
	
	public boolean willHit(PokeMove m, int acc) {
		return acc < m.getAccuracy();
	}
}
