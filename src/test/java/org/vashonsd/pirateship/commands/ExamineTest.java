package org.vashonsd.pirateship.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExamineTest {
	
	Command examine;

	@Before
	public void setUp() throws Exception {
		examine = new Examine();
	}

	@Test
	public void examineShouldHaveTwoKeywords() {
		assertTrue(examine.getKeywords().size() == 2);
	}

}
