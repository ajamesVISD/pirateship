package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;


public class Coin extends Actor {

	public Coin() {
		super("coin", "coin", "Use this to buy things", "There is a coin here.");
		setUp();
	}
	
	public Coin(String name) {
		super(name, "coin", "Use this to buy things", "There is a coin here.");
		setUp();
	}
	
	public Coin(String name, String description, String splash) {
		super(name, "coin", description, splash);
		setUp();
	}
	
	private void setUp() {
		this.enrollCommand(new Examine());
		this.setTypeNamePlural("coins");
		this.setTypeName("coin");
		this.enrollCommand(new Take());
		this.enrollCommand(new Drop());
		this.enrollCommand(new FlipCoin());
	}

}
