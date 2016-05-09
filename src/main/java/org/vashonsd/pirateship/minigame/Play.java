package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Play extends Command {

	Minigame minigame;
	
	public Play(Minigame m) {
		this.minigame = m;
		this.addKeyword("play");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
