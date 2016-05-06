package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.Player;
import org.vashonsd.pirateship.structure.Location;

public class TakeTest {
	Location here;
	Player player;

	@Before
	public void setUp() throws Exception {
		here = new Location("A grove", "It is mysterious.", "You're in a grove.");
		here.addToInventory(new Baguette());
		here.addToInventory(new Baguette());
		here.addToInventory(new Sword());
		player = new Player("Tim", "The enchanter");
		player.setLocation(here);
	}

	@Test
	public void test() {
		Response r = player.handle("take baguette");
		System.out.println(r.getText());
		Response r1 = player.handle("inventory");
		System.out.println(r1.getText());
	}

}
