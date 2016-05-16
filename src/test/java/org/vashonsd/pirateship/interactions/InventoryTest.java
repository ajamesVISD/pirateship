package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.interactions.*;
import org.vashonsd.pirateship.structure.Location;

public class InventoryTest {
	Actor player;
	Location loc;

	@Before
	public void setUp() throws Exception {
		player = new Player("Elise", "A rowdy woman with a heart of gold");
		loc = new Location("Grove", "It's peaceful", "A secret old place");
		player.setLocation(loc);
		player.addToInventory(new Baguette());
		player.addToInventory(new Baguette());
		player.addToInventory(new Sword("What a sword!"));
		player.addToInventory(new Sword("Gleaming Sword", "My, it gleams.", "A gleaming sword is here."));
		player.addToInventory(new Sword());
	}

	@Test
	public void playerShouldBeAbleToPrintInventory() {
		System.out.println(player.getInventory());
	}
	
	@Test
	public void inventoryShouldReturnAllItems() {
		System.out.println(player.inventory.getAllItems(VisibilityLevel.EXAMINE));
	}
	
	@Test
	public void testAddingItemShouldChangeItsLocation() {
		Actor b = new Sword();
		player.addToInventory(b);
		System.out.println(b.getLocation().getDescription());
	}
}
