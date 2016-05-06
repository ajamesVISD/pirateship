package org.vashonsd.pirateship.structure;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	private World w;
	private Location loc1;
	
	@Before
	public void setUp() throws Exception {
		w = new World("TestWorld");
		loc1 = new Location("First Place", "Where we start", "The first place");
		w.addLocation(loc1);
	}

	@Test
	public void testAddLocation() {
		assertTrue(w.getLocations().size() == 1);
	}
	
	@Test
	public void testWorldShouldHaveStartingLocation() {
		w.setStartingLocation(loc1);
		System.out.println(w.getStartingLocation().getDescription());
		assertNotNull(w.getStartingLocation());
	}

	@Test
	public void testLocationsShouldGetUniqueIDs() {
		w.addLocation("First Place", "Not the same as where we start", "Enter");
		w.addLocation("First Place", "Another first place!", "Enter");
		ArrayList<Location> locs = w.getLocations();
		Set<Location> set = new HashSet<Location>(locs);
		assertTrue(set.size() == locs.size());
	}
}
