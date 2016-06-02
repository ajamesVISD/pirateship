package org.vashonsd.pirateship.commands;

import java.util.*;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class FlipCoin extends Command {

	public FlipCoin() {
		super();
		this.addKeywords("flip");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		String text = "";
		Random s = new Random();
		if(player.hasByTypeName("coin")) {
			if(s.nextBoolean()) {
				text = "You got heads!";
				
			}
			else {
				text = "You got tails!";
			}
		}
		else {
			text = "You have no coin to flip with!";
		}
		r.setText(text);
		return r;
	}

}
