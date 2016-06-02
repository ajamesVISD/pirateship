package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.creature.Creature;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.minigame.Interactions;
import org.vashonsd.pirateship.minigame.MinigameRunner;

public class Talk extends Command {
	
	Creature c;
	
	public Talk(Creature c) {
		this.c = c;
		this.addKeywords("talk to", "talk with", "speak to", "speak with", "chat with", "converse with");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Interactions i = new Interactions(c);
		MinigameRunner run = new MinigameRunner(i);
		player.getLocation().addToInventory(run);
		return player.handle("play interact");
	}

}
