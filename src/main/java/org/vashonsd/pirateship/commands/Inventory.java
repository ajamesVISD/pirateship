package org.vashonsd.pirateship.commands;

import java.util.Set;
import java.util.Stack;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Response;

public class Inventory extends Command {
	
	public Inventory() {
		super();
		addKeyword("inventory");
	}
	
	@Override
	public Response execute(Actor obj, Actor from) {
		 return new Response(from.getInventory().toString());
	}
	
	
}
