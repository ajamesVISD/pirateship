package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.*;

public class LWGuardExamine extends Command {
	
	public LWGuardExamine() {
		super();
		this.addKeyword("examine");
		this.addKeyword("look at");
	}

	@Override
	public Response execute(Actor i, Player from) {
		Response r = new Response();
		if(from.hasByTypeName("gem") == false) {
			r.setText(i.getDescription());
		} else {
			r.setText("\"Is that the gem? Come with me.\"");
		}
		return r;
	}
}
