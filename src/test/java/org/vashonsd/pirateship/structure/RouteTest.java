package org.vashonsd.pirateship.structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RouteTest {
	
	private Route testRoute;
	private Location to;

	@Before
	public void setUp() throws Exception {
		to = new Location ("to", "the place we're going to");
		testRoute = new Route("A long pathway", "northwest", to);
	}

	@Test
	public void testRouteGoesToDestination() {
		assertSame(testRoute.getDestination(), to);
	}

}
