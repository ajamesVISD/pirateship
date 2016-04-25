package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InteractionsTest {

	private AvailableInteractions ai;
	
	@Before
	public void setUp() throws Exception {
		ai = new AvailableInteractions();
		ai.addInteractor(new Baguette());
		ai.addInteractor(new Book());
		ai.addInteractor(new East());
	}
	
	@Test
	public void testHandle() {
		String[] commands = new String[] {
				"eat baguette",
				"destroy baguette",
				"east",
				"go east",
				"eat east",
				"book",
				"read book",
				"examine book",
				"ghghgh book"
		};
		for (int i = 0; i < commands.length; i++)
		{
			System.out.println(commands[i] + ": " + ai.handle(new Request(commands[i])).getText());
		}
	}

}
