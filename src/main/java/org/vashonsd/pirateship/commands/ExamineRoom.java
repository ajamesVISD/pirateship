package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class ExamineRoom extends Command {
	
	public ExamineRoom() {
		addKeyword("examine");
		String[] examine = {"examine", "look at", "check", "check out"};
		String[] room = {"room", "area", "location"};
		for (int i = 0; i < examine.length; i++) {
			for (int j = 0; j < room.length; j++) {
				String key = examine[i] + " " + room[j];
				addKeyword(key);
			}
		}
	}

	@Override
	public Response execute(Actor obj, Player player) {
		return new Response(player.getLocation().getDescription());
	}

}
