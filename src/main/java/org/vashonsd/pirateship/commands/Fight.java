package org.vashonsd.pirateship.commands;


import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.minigame.Combat;
import org.vashonsd.pirateship.minigame.text.*;

public class Fight extends Command {

	public Fight() {
		addKeywords("fight", "attack", "kill", "Fight", "Attack", "Kill");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		Response r = new Response();
		String s = "You begin fighting "+obj.getName()+".";
		r.setText(s);
		Combat c = new Combat(obj);
		player.getLocation().addToInventory(c);
		return player.handle("play combat");
	}

}
