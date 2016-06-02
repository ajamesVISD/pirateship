package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Give extends Command {

	Player p;
	
	public Give(Player p) {
		super();
		this.p = p;
		for(Actor item: p.getAllItems()) {
			addKeyword("give " + item.getTypeName() + " to");
		}
	}
	
	@Override
	public Response execute(Actor obj, Player player) {
		String str = "give lizard to";
		String[] splitStr = str.split(" ");
		String item = splitStr[1];
		return null;
	}

}
