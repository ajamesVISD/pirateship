package org.vashonsd.pirateship.minigame;


import org.vashonsd.pirateship.interactions.Actor;

import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

public class TreasureChest extends Minigame {
	
	private boolean open = false;
	private int stage = 1;
	private Actor a;

	
	public TreasureChest(Actor item) {
		super("Treasure Chest", "open", "This chest could hold treasue!" , "There is a chest here. ");
		// TODO Auto-generated constructor stub
		a = item;
	}

	@Override
	public String getGreeting() {
		return "Open chest?";
	}

	@Override
	public Response handleOtherwise(Request req) {
		if(stage == 1 && open == false)
		{
			stage = 2;
			response.setText(getGreeting());
			open = true;
			return response;
		}
		else if (stage == 2) 
		{
			if(req.getText().equalsIgnoreCase("Yes")) {
				
				req.getPlayer().addToInventory(a);
				response.setText("There was a/an " + a.getName() + " in the chest");
				return response;
			}
			else {
				this.response.setText("Chest is already open");
				return response;
			
			}
		
		}
		return null;
	}

	@Override
	public String getPrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExit() {
		String s = "You got a/an " + a.getName();
		stage = 1;
		
		return s;
	}

}
