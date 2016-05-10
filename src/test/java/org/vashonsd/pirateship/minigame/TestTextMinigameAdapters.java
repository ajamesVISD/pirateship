package org.vashonsd.pirateship.minigame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.minigame.text.TextMinigameFactory;
import org.vashonsd.pirateship.minigame.text.TwentyQuestionsFactory;

public class TestTextMinigameAdapters {

	TextMinigameFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new TwentyQuestionsFactory();
	}

//	@Test
//	public void textMinigameFactoryShouldProduceTextMinigame() {
//		assertFalse(factory.newGame() == null);
//		System.out.println(factory.newGame().getClass());
//		System.out.println(factory.newGame().Run());
//	}

	@Test
	public void textMinigameAdapterShouldReturnGreeting() {
		System.out.println(factory.getClass());
		TextMinigameAdapter game = new TextMinigameAdapter(factory);
		assertFalse(game.minigame == null);
		//System.out.println(game.getGreeting());
	}
}
