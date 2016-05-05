 package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InteractionsTest {

	private AvailableInteractions ai;
	
	@Before
	public void setUp() throws Exception {
		ai = new AvailableInteractions();
		ai.addActor(new Baguette());
	}
	
	
	
	@Test
	public void testHandle() {
		String[] commands = new String[] {
				"examine baguette",
				"look at baguette",
				"murf baguette",
				"examine doodlesquat",
				"harm baguette"
		};
		for (int i = 0; i < commands.length; i++)
		{
			System.out.println(commands[i] + ": " + ai.handle(new Request(commands[i])).getText());
		}
	}

}
