package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Take;

public class GoldCoin extends Actor {

	public GoldCoin() {
		super("Gold Coin", "coin", "A small gold coin with an indistinct face on one side, can be spent at shops", "A coin lies on the ground, Spend me!");
		this.enrollCommand(new Take());
	}
}
