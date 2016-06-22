package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.LWGem;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class LWGemdealerExamine extends Command {
	public LWGemdealerExamine() {
		super();
		this.addKeyword("examine");
		this.addKeyword("look at");
	}

	@Override
	public Response execute(Actor i, Player from) {
		Response r = new Response();
		r.setText(i.getDescription());
		from.addToInventory(new LWGem());
		return r;
	}
}
