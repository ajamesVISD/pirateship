package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.Player;
import org.vashonsd.pirateship.structure.Location;

public class PlayerTest {

	Player nina;
	Location here;
	
	@Before
	public void setUp() throws Exception {
		nina = new Player("Nina", "A wild girl with a heart of gold.");
		here = new Location("here", "A lovely grove.", "You are here");
		nina.setLocation(here);
		here.addToInventory(new Baguette());
		nina.addToInventory(new Sword());
	}

	@Test
	public void testHandle() {
		String[] cmds = new String[] {
				"examine baguette",
				"look at baguette",
				"murf baguette",
				"examine doodlesquat",
				"examine sword",
				"harm baguette",
				"jump",
				"leap",
				"help"
		};
		for (int i = 0; i < cmds.length; i++)
		{
			System.out.println(cmds[i] + ": " + nina.handle(cmds[i]).getText());
		}
	}

}
