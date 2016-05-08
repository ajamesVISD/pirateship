package org.vashonsd.pirateship.interactions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.vashonsd.pirateship.structure.Location;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@RunWith(Suite.class)
@SuiteClasses({ 
	ActorTest.class,
	InteractionsTests.class,
	InventoryTest.class,
	LocationTest.class,
	PlayerTest.class,
	TakeTest.class 
	})

public class InteractionTestSuite {
	static Location loc1;
	Location loc2;

	@BeforeClass
	public static void SetUpClass() {
		loc1 = new Location("Chapel", "An inspiring place", "You're in the chapel.");
	}
	
	@AfterClass
	public static void TearDownClass() {
		
	}
}
