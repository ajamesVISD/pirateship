package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.*;

public class Medic extends Minigame {
	
	private int amountOfBandage = 0;
	private int stage = 1;

	public Medic() {
		super("medic", "medic", "Here you can try to earn a bandage to heal your friends" , "There is a medic here");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getGreeting() {
		return "If you want another bandage just ask!";
	}

	@Override
	public Response handleOtherwise(Request req) {
		if(stage == 1) {
			stage = 2;
			response.setText(getGreeting());
			return response;
			
		}
		else if(stage == 2) {
			if(req.getText().equalsIgnoreCase("Can I have a bandage?")) {
				req.getPlayer().addToInventory(new Bandage());
				amountOfBandage++;
				response.setText("Here you go! \n you now have " + amountOfBandage + " Bandages.");
				return response;
			}
			else {
				this.response.setText("Ask me differently (Can I have a bandage?)");
				return response;
			}
		}
		return response;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExit() {
		String s = "I hope you use these " + amountOfBandage + " bandages wisely.";
		stage = 1;
		amountOfBandage = 0;
		
		return s;
	}

}
