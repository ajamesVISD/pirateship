package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.*;

public class Shop extends Minigame {

	private int lines;
	
	public Shop() {
		super("Bob", "shop", "Buy potions", "A bored looking gentleman in a white apron leans on a counter stocked with bottles labeled \"Potion\"");
		lines = 0;
	}
	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hey I'm Bob the shopkeep, you wanna buy a Potion? Just one gold piece.";
	}

	@Override
	public Response handleOtherwise(Request req) {
		// TODO Auto-generated method stub
		Player player = req.getPlayer();
		
		if(lines == 0) {
			lines++;
			if(player.getInventory().hasActorType("coin")) {
				int coins = 0;
				for(Actor a: player.getInventory().getAllItems()) {
					if(a.getTypeName().equalsIgnoreCase("coin")) {
						coins++;
					}
				}
				
				this.response.setText("How many would you like? (" + coins + " max)");
				return response;
			} else {
				this.response.setText("Come back when you have some gold.");
				return response;
			}
		}
		if(lines == 1) {
			int coin;
			try {
				coin = Integer.parseInt(req.getText());
			} catch(NumberFormatException err) {
				this.response.setText("I don't know how many potions " + req.getText() + " is, give me a number.");
				return response;
			}
			
			for(int i=0; i<coin; i++) {
				player.removeActorTypeFromInventory("coin");
				player.addToInventory(new Potion());
			}
			this.response.setText("Here you go, come again.");
			return response;
		}
		
		this.response.setText("Goodbye");
		return response;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Bob";
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		lines = 0;
		return "Goodbye";
	}

}
