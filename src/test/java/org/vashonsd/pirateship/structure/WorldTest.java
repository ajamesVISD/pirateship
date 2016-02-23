package org.vashonsd.pirateship.structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	private World w;
	
	@Before
	public void setUp() throws Exception {
		w = new World("TestWorld");
	}

	@Test
	public void testAddLocation() {
		Location l = new Location("First Place", "Where we start");
		w.addLocation(l);;
	}

}
