package org.vashonsd.pirateship.minigame;

import java.util.*;

import org.vashonsd.pirateship.commands.*;
import org.vashonsd.pirateship.interactions.*;

public class Combat extends Minigame {

	private Actor enemy;
	private int stage = 1;
	private Player player;
	private Random r = new Random();
	
	public Combat(Actor enemy) {
		super("", "combat", "", "");
		this.enemy = enemy;
		this.exitWord = "flee";
	}

	@Override
	public String getGreeting() {
		return null;
	}

	@Override
	public Response handleOtherwise(Request req) {
	if(stage==0) {
		player.getLocation().removeFromInventory(this);
		return new Response("You have been defeated by "+enemy.getName()+".\n");
	}
	else if(stage == 1) {
			player = req.getPlayer();
			stage++;
			response.setText("You begin fighting "+enemy.getName()+".\nYour avialiable actions are: [attack] [defend] or [flee]");
			return response;
		}
		else if(stage == 2) {
			if(req.getText().equalsIgnoreCase("attack")) {
				int sent = (int) damage(player, enemy);
				int recieve = (int) damage(enemy, player);
				player.changeHealth(recieve*(-1));
				enemy.changeHealth(sent*(-1));
				
				String s = "You deal "+enemy.getName()+" ";
				s+=sent+" damage, and you recieved "+recieve+" damage.";
				response.setText(s);
				
				if(enemy.isAlive()==false) {stage++;}
				else if(player.isAlive()==false) {stage=0;}
				return response;
			}
			else if(req.getText().equalsIgnoreCase("defend")) {
				response.setText(enemy.getName()+" attempts to deal "+(int)damage(enemy, player)+" but fails.");
				return response;
			}
			else if(req.getText().equalsIgnoreCase("flee")) {
				return new Response(getExit());
			}
			else {
				response.setText("That isn't a valid action.");
				return response;
			}	
		}
		else if(stage==3) {
			player.getLocation().removeFromInventory(this);
			return new Response("You have defeated "+enemy.getName()+".\n");
		}
		else {
			response.setText("I've lost track of things.");
			return response;
		}
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExit() {
		player.getLocation().removeFromInventory(this);
		return "You flee from "+enemy.getName()+".\n";
	}
	
	public double damage(Actor from, Actor to) {
		double d;
		d = from.getAttack()*(0.1)*(r.nextInt(10)+1);
		d-=to.getDefense();
		if(d<0) {
			d=0;
		}
		return d;
	}

}
