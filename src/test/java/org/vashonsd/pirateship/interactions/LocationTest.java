package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.structure.Location;

public class LocationTest {

	Location loc;
	
	@Before
	public void setUp() throws Exception {
		loc = new Location("Chapel", "An inspiring place", "You're in the chapel.");
	}

	@Test
	public void testLocationShouldHaveInventory() {
		System.out.println(loc.getInventory().getAllItems());
		loc.addToInventory(new Baguette());
		System.out.println(loc.getInventory().getAllItems());
	}

}
