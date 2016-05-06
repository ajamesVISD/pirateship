package org.vashonsd.pirateship.structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RouteTest {
	
	private Location here;
	private Location there;

	@Before
	public void setUp() throws Exception {
		here = new Location("here", "a pleasant grove", "go here");
		there = new Location("there", "a terrible place where no one ought to go.", "go there");
	}

	@Test
	public void testRouteGoesToDestination() {
		here.addRoute("a winding staircase", "up", there);
	}

}
