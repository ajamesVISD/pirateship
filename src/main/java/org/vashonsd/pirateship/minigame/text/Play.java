package org.vashonsd.pirateship.minigame.text;

import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Play extends Command {

	TextMinigame minigame;
	
	public Play(TextMinigame m) {
		this.minigame = m;
		this.addKeyword("play");
	}

	@Override
	public Response execute(Actor obj, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
