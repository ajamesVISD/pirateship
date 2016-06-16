package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.interactions.poke.*;
import org.vashonsd.pirateship.minigame.text.Randomizer;

public class PokemonBattle extends Minigame {
	
	Pokemon you;
	Pokemon opponent;
	PokemonGenerator gen;
	PokeMoveGenerator mGen;
	Boolean hasMove;
	Boolean firstTime;
	Boolean wonLast;
	Boolean firstLine;
	
	public PokemonBattle() {
		super("Gary", "battle", "Battle pokemon", "A smug looking chump, who's name is quite likely Gary, stands in the middle of the arena tossing a pokeball in the air.");
		gen = new PokemonGenerator();
		mGen = new PokeMoveGenerator();
		hasMove = false;
		firstTime = true;
		wonLast = false;
		firstLine = false;
	}
	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		if(firstTime == false) {
			if(wonLast == true)
				return "Back again so soon? Prepare to lose again.";
			else if(wonLast == false)
				return "Last time was just a fluke, I'll get you this time.";
		}
		
		firstTime = false;
		return "Ready to battle Ash?";
	}

	@Override
	public Response handleOtherwise(Request req) {
		// TODO Auto-generated method stub
		Player player = req.getPlayer();
		
		if(!player.getInventory().hasActorType("pokemon")) {
			this.response.setText("Come back when you have a pokemon");
			return response;
		}
		
		if(firstLine == false) {
			this.you = (Pokemon)req.getPlayer().getInventory().getActorByTypeName("pokemon");
			opponent = gen.squirtle();
			opponent.addMove(mGen.withdraw());
			opponent.addMove(mGen.tailWhip());
			opponent.addMove(mGen.waterGun());
			opponent.addMove(mGen.tackle());
			firstLine = true;
			if(player.getInventory().hasActorType("potion")) 
				this.response.setText("Battle!!!\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves() + "\nPotion:\n refill 1/2 HP");
			else
				this.response.setText("Battle!!!\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves());
			
			return response;
		}
		
		if(!you.isDead() && !opponent.isDead())
		{
			int youAcc = Randomizer.nextInt(100);
			int oppAcc = Randomizer.nextInt(100);
			PokeMove oppMove = opponent.getMoves().get(Randomizer.nextInt(3));
			String toReturn = "";
			
			if(yourMove()) {
				for(PokeMove m: you.getMoves()) {
					
					if(req.getText().equalsIgnoreCase(m.getName())) {
						hasMove = true;
						
						if(willHit(m, youAcc)) {
							hit(you, opponent, m);
							toReturn += "You used " + m.getName() + m.getType().effString(opponent.getType()) + "\n";
						} else {
							toReturn += "You used " + m.getName() + " it missed.\n";
						}
						
						break;
					} else if(req.getText().equalsIgnoreCase("potion")) {
						potion(player, you);
						toReturn += "You used a potion.";
						break;
					}
				}
				
				if(hasMove == false) {
					this.response.setText("You must chose a valid move.");
					return response;
				}
				if(you.isDead() || opponent.isDead()) {
					this.response.setText(you.battleHUD(opponent) + getWinner(player).getName() + " wins.");
					return response;
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
						this.response.setText(getWinner(player).getName() + " wins.");
						return response;
					}
					
					for(PokeMove m: you.getMoves()) {
						
						if(req.getText().equalsIgnoreCase(m.getName())) {
							hasMove = true;
							
							if(willHit(m, youAcc)) {
								hit(you, opponent, m);
								toReturn += "You used " + m.getName() + m.getType().effString(opponent.getType()) + "\n";
							} else {
								toReturn += "You used " + m.getName() + " it missed.\n";
							}
							
							break;
						} else if(req.getText().equalsIgnoreCase("potion")) {
							potion(player, you);
							toReturn += "You used a potion.";
							break;
						}
				}
				
					if(hasMove == false) {
						this.response.setText("You must chose a valid move.");
						return response;
					}
			}
			
			if(player.getInventory().hasActorType("potion")) 
				this.response.setText(toReturn + "\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves() + "\nPotion:\n refill 1/2 HP");
			else
				this.response.setText(toReturn + "\n\n" + you.battleHUD(opponent) + "\n" + you.printMoves());
			
			return response;
		}
		
		this.response.setText(you.battleHUD(opponent) + getWinner(player).getName() + " wins.");
		return response;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Gary";
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		firstLine = false;
		return "Goodbye";
	}
	
	public void hit(Pokemon source, Pokemon target, PokeMove move) 
	{
		source.changeHP(move.getHealthGain());
		double damage = ((((source.getAttack())/100)*(move.getPower()))*((100 - target.getDefense())/100))*move.getType().isEffective(target.getType());
		if(damage<1 && damage>0) {
			damage = 1;
		} else if(damage <= 0) {
			damage = 0;
		}
		target.changeHP(-damage);
		source.changeAttack(move.getMyAttackChange());
		target.changeAttack(move.getAttackChange());
		source.changeDefense(move.getMyDefenseChange());
		target.changeDefense(move.getDefenseChange());
		source.changeSpeed(move.getMySpeedChange());
		target.changeSpeed(move.getSpeedChange());
		source.changeAccuracy(move.getMyAccuracyChange());
		target.changeAccuracy(move.getAccuracyChange());
	}
	
	public void potion(Actor trainer, Pokemon target) {
		if(trainer.getInventory().hasActorType("potion")) {
			target.changeHP(target.getMaxHP()/2);
			trainer.getInventory().remove(trainer.getInventory().getActorByTypeName("potion"));
		}
	}
	
	public boolean yourMove() {
		return you.getSpeed() >= opponent.getSpeed();
	}
	
	public Pokemon getWinner(Player player) {
		if(you.isDead()) {
			wonLast = true;
			return opponent;	
		}
		
		wonLast = false;
		player.addToInventory(new GoldCoin());
		return you;
	}
	
	public boolean willHit(PokeMove m, int acc) {
		return acc < m.getAccuracy();
	}

}
