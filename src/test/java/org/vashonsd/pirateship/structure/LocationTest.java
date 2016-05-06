package org.vashonsd.pirateship.structure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	Location testLoc;

	@Before
	public void setUp() throws Exception {
		testLoc = new Location("test location", "in a testing place", "here comes the test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertTrue(testLoc.getName()=="test location");
	}

}
