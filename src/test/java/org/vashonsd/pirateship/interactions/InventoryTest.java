package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.Player;
import org.vashonsd.pirateship.interactions.*;

public class InventoryTest {
	Actor player;

	@Before
	public void setUp() throws Exception {
		player = new Player("Elise", "A rowdy woman with a heart of gold");
		player.addToInventory(new Baguette());
		player.addToInventory(new Baguette());
		player.addToInventory(new Sword("What a sword!"));
		player.addToInventory(new Sword("Gleaming Sword", "My, it gleams."));
		player.addToInventory(new Sword());
	}

	@Test
	public void playerShouldBeAbleToPrintInventory() {
		System.out.println(player.getInventory());
	}

}
