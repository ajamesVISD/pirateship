package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.commands.Examine;

public class ActorTest {
	
	Actor baguette;
	Request request;
	Response response;

	@Before
	public void setUp() throws Exception {
		baguette = new Baguette();
		request = new Request("examine baguette");
	}

	@Test
	public void baguetteShouldGetItsName() {
		assertTrue("The baguette's name is " + baguette.getName(), baguette.getName().equals("baguette"));
	}

	@Test
	public void baguetteShouldBeExaminable() {
		response = baguette.handle("examine", request);
		assertFalse(response.getText().isEmpty());
		assertTrue(response.getText().equals("A delicious baguette"));
	}
	
	@Test
	public void baguetteShouldDie() {
		
	}
}
