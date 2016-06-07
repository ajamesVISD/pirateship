package org.vashonsd.pirateship.minigame.playingcards;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.vashonsd.pirateship.*;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests extends AppTest {

	public AllTests(String testname) {
		super(testname);
	}
	
	public void testRemove()
	{
		Card c1 = new Card(3, 'S');
		Card c2 = new Card(3, 'H');
		Card c3 = new Card(4, 'C');
		Card c4 = new Card(5, 'D');
		
		Hand hand = new Hand();
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);
		
		Hand otherHand = new Hand();
		otherHand.addCard(c3);
		otherHand.addCard(c4);
		
		hand.removePair(3);
		
		assertTrue( hand.getValue() == otherHand.getValue() );
	}
	
}
