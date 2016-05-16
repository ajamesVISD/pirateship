 package org.vashonsd.pirateship.interactions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.vashonsd.pirateship.commands.Command;
import org.vashonsd.pirateship.commands.Examine;
import org.vashonsd.pirateship.commands.Go;
import org.vashonsd.pirateship.creature.Creature;
import org.vashonsd.pirateship.minigame.TextMinigameAdapter;
import org.vashonsd.pirateship.minigame.text.TwentyQuestionsFactory;
import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.Route;

public class InteractionsTests {

	Location here;
	Location there;
	
	Actor yoyo1;
	Actor yoyo2;
	Creature cricket;
	
	Command play;
	Command examine;
	
	Player nina;
	
	Request request;
	Response response;
	
	Route route;
	
	AvailableInteractions ai;
	Inventory inventory;
	
	@Before
	public void setUp() throws Exception {
		ai = new AvailableInteractions();
		
		here = new Location("here", "It is your bedroom.", "You have started here.");
		there = new Location("there", "It is a faraway location", "You have gone far away.");
		
		route = new Route("east", "It is a golden path leading east.", "You can follow a path east", here, there);
		
		here.addToInventory(route);
		
		yoyo1 = new Yoyo("Charley", "It is green, and looks snazzy.", "There is a yoyo here.");
		yoyo2 = new Yoyo("Eliza", "Eliza Jane", "There is a yoyo here.");
		cricket = new Cricket("cricket", "What a lovely cricket.", "You hear a cricket chirp.");
		
		play = new Play();
		examine = new Examine();
		
		nina = new Player("Nina", "A wild girl with a heart of gold.");
		nina.setLocation(here);
		
		inventory = new Inventory();
	}
	
	/**
	 * Interactions tests
	 */
	@Test
	public void addingToPlayerInventoryIncrementsInteractions() {
		int a = ai.getAllActors().size();
		ai.addActor(cricket);
		assertEquals(ai.getAllActors().size(), a + 1);
	}
	
	@Test
	public void shouldReturnActorsGroupedByType() {
		ai.addActor(yoyo1);
		ai.addActor(yoyo2);
		System.out.println(ai.getAllActorsByType());
		assertEquals(ai.getAllActorsByType().get("yoyo").size(), 2);
	}
	
	/**
	 * Location tests
	 */
	@Test
	public void locationShouldBeTraversable() {
		assertTrue(here.isTraversable());
	}
	
	/**
	 * Actor tests
	 */
	@Test
	public void actorShouldReturnSplash() {
		assertEquals(yoyo1.getSplashText(), "There is a yoyo here.");
	}
	
	/**
	 * Player tests
	 */
	@Test
	public void playerShouldReturnName() {
		assertEquals(nina.getName(),"Nina");
	}
	
	/**
	 * Command tests
	 */
	@Test
	public void commandsShouldHaveKeywords() {
		ArrayList<String> keywords = play.getKeywords();
		boolean f = false;
		for (String k : keywords) {
			if (k.equals("play")) { f = true; }
		}
		assertTrue(f);
	}
	
	/**
	 * Route tests
	 */
	@Test
	public void routesShouldTakeUsToThere() {
		assertEquals(route.getDestination(), there);
	}
	
	@Test
	public void routesShouldStartHere() {
		assertEquals(route.getLocation(), here);
	}
	
	@Test
	public void routesShouldHaveGoCommand() {
		assertTrue(route.getCommands().containsKey("go"));
	}
	
	/**
	 * Inventory tests
	 */
	@Test
	public void inventoryShouldAddItems() {
		int a = inventory.getAllItems().size();
		inventory.addActor(yoyo1);
		assertEquals(inventory.getAllItems().size() - a, 1);
	}
	
	@Test
	public void routesShouldChangePlayerLocation() {
		here.addToInventory(cricket);
		request = new Request("east", nina);
		System.out.println(nina.handle(request.getText()).getText());
		assertEquals(nina.getLocation().getName(), "there");
	}
	
	/**
	 * Clarifier test
	 */
	@Test
	public void clarifierShouldAskNames() {
		Clarifier c = new Clarifier("paste");
		c.addActors(yoyo1);
		c.addActors(yoyo2);
		System.out.println("Clarification: " + c.clarify().getText());
	}
	
	/**
	 * TextMinigameAdapter tests
	 */
	@Test
	public void textMinigameAdapterShouldHoldaNewGame() {
		TextMinigameAdapter mini = new TextMinigameAdapter(new TwentyQuestionsFactory());
		System.out.println(mini.getGreeting());
	}
	
	
//	@Test
//	public void testHandle() {
//		String[] commands = new String[] {
//				"examine baguette",
//				"look at baguette",
//				"murf baguette",
//				"examine doodlesquat",
//				"harm baguette",
//				"jump",
//				"leap"
//		};
//		for (int i = 0; i < commands.length; i++)
//		{
//			System.out.println(commands[i] + ": " + ai.handle(new Request(commands[i])).getText());
//		}
//	}

}
