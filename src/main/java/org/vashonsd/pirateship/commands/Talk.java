package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.creature.Creature;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Talk extends Command {
	
	Creature c;
	
	public Talk(Creature c) {
		this.c = c;
		this.addKeywords("talk to", "talk with", "speak to", "speak with", "chat with", "converse with");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		r.setText(c.getSpeechBehavior().Speak());
		return r;
	}

}
