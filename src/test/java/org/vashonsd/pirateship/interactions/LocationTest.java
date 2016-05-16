package org.vashonsd.pirateship.interactions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.structure.Location;

public class LocationTest {

	@Test
	public void testLocationShouldHaveInventory() {
		System.out.println(loc1.getInventory().getAllItems());
		loc1.addToInventory(new Baguette());
		System.out.println(loc1.getInventory().getAllItems());
	}

}
