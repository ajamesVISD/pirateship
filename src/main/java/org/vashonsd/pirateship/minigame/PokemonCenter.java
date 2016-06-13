package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.*;

public class PokemonCenter extends Minigame {

	private int lines;
	
	public PokemonCenter() {
		super("Nurse Joy", "heal", "Heal your Pokemon", "A smiling woman in a nurse's uniform stand behind a counter.");
		lines = 0;
	}
	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hello, my name is Nurse Joy, and this is a pokemon center.";
	}

	@Override
	public Response handleOtherwise(Request req) {
		// TODO Auto-generated method stub
		Player player = req.getPlayer();
		if(!player.getInventory().hasActorType("Pokemon")) {
			this.response.setText("Come back with a Pokemon.");
			return response;
		}
		
		if(lines == 0) {
			lines++;
			this.response.setText("Would you like me to heal your pokemon to full health?");
			return response;
		}
		if(lines == 1) {
			if(req.getText().equalsIgnoreCase("yes")) {
				player.getInventory().getActorByTypeName("pokemon").changeHP(1000.00);
				lines++;
				this.response.setText("Ok, I'll take your pokemon for a moment.");
				return response;
			}
		}
		if(lines == 2) {
			this.response.setText("Your Pokemon has been restored to full health, have a nice day.");
			return response;
		}
		
		this.response.setText("Goodbye");
		return response;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Joy";
	}

	@Override
	public String getExit() {
		// TODO Auto-generated method stub
		lines = 0;
		return "Goodbye.";
	}

}
