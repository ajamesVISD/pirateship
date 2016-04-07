package org.vashonsd.pirateship.minigame;

import java.util.*;

public class PrisonEscape implements Minigame {
	// Your warden
	private Pig pig = new Pig();
	
	// Keeps track of the current tier of questioning
	private ArrayList<String> currentPrompt;
	private String lastPrompt = "";
	
	public static int MAXQUES = 20;
	public static int MAXLEVEL = 10;
	public static int LOWLEVEL = -10;
	
	/*
	 * QUESTION TIERS.
	 */
	// Basic prompt starters
	public static ArrayList<String> basicPrompts = new ArrayList<String> ();
	
	// Extensions of basic prompt starters
	public static ArrayList<String> doPrompts = new ArrayList<String> ();
	public static ArrayList<String> canPrompts = new ArrayList<String> ();
	public static ArrayList<String> arePrompts = new ArrayList<String> ();
	public static ArrayList<String> wouldPrompts = new ArrayList<String> ();
	
	// Extensions of "do you"
	public static ArrayList<String> doLikePrompts = new ArrayList<String> ();
	public static ArrayList<String> doThinkPrompts = new ArrayList<String> ();
	public static ArrayList<String> doBelievePrompts = new ArrayList<String> ();
	
	// Extensions of "can you"
	public static ArrayList<String> canTellPrompts = new ArrayList<String> ();
	public static ArrayList<String> canGivePrompts = new ArrayList<String> ();
	public static ArrayList<String> canDoPrompts = new ArrayList<String> ();

	// Extensions of "would you"
	public static ArrayList<String> wouldLikePrompts = new ArrayList<String> ();
	public static ArrayList<String> wouldGoPrompts = new ArrayList<String> ();
	
	// Extensions of "are you"
	public static ArrayList<String> areGoodPrompts = new ArrayList<String> ();
	public static ArrayList<String> areScaredPrompts = new ArrayList<String> ();
	public static ArrayList<String> areActuallyPrompts = new ArrayList<String> ();
	
	
	static {
		// Adding to the basic prompt starters
		basicPrompts.add("do you");
		basicPrompts.add("can you");
		basicPrompts.add("would you");
		basicPrompts.add("are you");
		
		/*
		 * BASIC PROMPTS
		 */
		// Adding to the "do you" prompts
		doPrompts.add("like");
		doPrompts.add("think");
		doPrompts.add("believe in");
		doPrompts.add("  <-- back");
		
		// Adding to the "can you" prompts
		canPrompts.add("tell me");
		canPrompts.add("give me");
		canPrompts.add("do");
		canPrompts.add("  <-- back");
		
		// Adding to the "are you" prompts
		arePrompts.add("good at");
		arePrompts.add("scared of");
		arePrompts.add("actually");
		arePrompts.add("  <-- back");
		
		// Adding to the "would you" prompts
		wouldPrompts.add("like to");
		wouldPrompts.add("go to");
		wouldPrompts.add("  <-- back");
		
		/*
		 * "DO YOU" PROMPTS
		 */
		// Adding to the "do you like" prompts
		doLikePrompts.add("food");
		doLikePrompts.add("sci fi");
		doLikePrompts.add("the super bowl");
		doLikePrompts.add("long graduation speeches");
		doLikePrompts.add("all things");
		doLikePrompts.add("voodoo");
		doLikePrompts.add("putting people in their place");
		doLikePrompts.add("  <-- back");
		
		// Adding to the "do you think" prompts
		doThinkPrompts.add("i'm pretty");
		doThinkPrompts.add("you're pretty");
		doThinkPrompts.add("you're cool");
		doThinkPrompts.add("the end is nigh");
		doThinkPrompts.add("we're in the matrix");
		doThinkPrompts.add("the government is made of alien lizards");
		doThinkPrompts.add("  <-- back");
		
		// Adding to the "do you believe in" prompts
		doBelievePrompts.add("ghosts");
		doBelievePrompts.add("the force");
		doBelievePrompts.add("dumbledore");
		doBelievePrompts.add("believing in things");
		doBelievePrompts.add("the moon");
		doBelievePrompts.add("honest work");
		doBelievePrompts.add("dumb luck");
		doBelievePrompts.add("sleeping in");
		doBelievePrompts.add("  <-- back");
		
		
		/*
		 * "CAN YOU" PROMPTS
		 */

		// Adding to the "can you tell me" prompts
		canTellPrompts.add("a joke");
		canTellPrompts.add("a secret");
		canTellPrompts.add("an idea");
		canTellPrompts.add("some gossip");
		canTellPrompts.add("the meaning of life");
		canTellPrompts.add("something cool");
		canTellPrompts.add("something weird");
		canTellPrompts.add("something");
		canTellPrompts.add("  <-- back");
		
		// Adding to the "can you give me" prompts
		canGivePrompts.add("something to eat");
		canGivePrompts.add("a smile");
		canGivePrompts.add("advice");
		canGivePrompts.add("a sweet hotwheels collection");
		canGivePrompts.add("your hand in marriage");
		canGivePrompts.add("  <-- back");
		
		// Adding to the "can you do" prompts
		canDoPrompts.add("a backflip");
		canDoPrompts.add("magic");
		canDoPrompts.add("a tumblr");
		canDoPrompts.add("pi");
		canDoPrompts.add("murder");
		canDoPrompts.add("absolutely nothing");
		canDoPrompts.add("  <-- back");

		
		/*
		 * "WOULD YOU" PROMPTS
		 */
		// Adding to the "would you like to" prompts
		wouldLikePrompts.add("watch tv with me");
		wouldLikePrompts.add("build a snowman");
		wouldLikePrompts.add("take over the world");
		wouldLikePrompts.add("get a life");
		wouldLikePrompts.add("go to the bathroom");
		wouldLikePrompts.add("lay on the ground and feel like trash");
		wouldLikePrompts.add("  <-- back");

		// Adding to the "would you go to" prompts
		wouldGoPrompts.add("mars");
		wouldGoPrompts.add("the caribbean");
		wouldGoPrompts.add("narnia");
		wouldGoPrompts.add("the internets");
		wouldGoPrompts.add("your room");
		wouldGoPrompts.add("my funeral");
		wouldGoPrompts.add("  <-- back");
		
		
		/*
		 * "ARE YOU" PROMPTS
		 */
		// Adding to the "are you good at" prompts
		areGoodPrompts.add("sports");
		areGoodPrompts.add("the arts");
		areGoodPrompts.add("brain stuff");
		areGoodPrompts.add("being cool");
		areGoodPrompts.add("breathing");
		areGoodPrompts.add("procrastinating");
		areGoodPrompts.add("over-analyzing");
		areGoodPrompts.add("everything");
		areGoodPrompts.add("  <-- back");
		
		// Adding to the "are you scared of" prompts
		areScaredPrompts.add("idiots");
		areScaredPrompts.add("insomnia");
		areScaredPrompts.add("the dark side");
		areScaredPrompts.add("public speaking");
		areScaredPrompts.add("people knowing how dead you are inside");
		areScaredPrompts.add("  <-- back");
		
		// Adding to the "are you actually" prompts
		areActuallyPrompts.add("a zombie");
		areActuallyPrompts.add("a unicorn");
		areActuallyPrompts.add("a sloth");
		areActuallyPrompts.add("a smartass");
		areActuallyPrompts.add("a jedi master");
		areActuallyPrompts.add("the devil himself");
		areActuallyPrompts.add("  <-- back");
		
	}

	public PrisonEscape() {
		super();
		currentPrompt = basicPrompts;
		pig.setPigPrintFront();
		pig.getBeginningSpeech();
	}
	
	

	public String Run() {
		String pigText = "";
		pigText += "You awaken in your dank prison cell to the sound of hoofs clanking against the bars.\n"
				+ "It's the day of your execution. Your pig warden is here to take you to the chair.\n"
				+ "You think in retrospect that maybe TacoBell wasn't the best idea for a last meal.\n";
		pigText += pig.getBeginningSpeech();
		pigText += "\n\nIt's now or never. you have " + MAXQUES + " chances. Convince your warden to let you out of Pig Prison.";
		pigText += "\n\n" + getPigText();
		return pigText;
	}
	
	/*
	 * Gets full pig text including pigs name, quip, and prompts
	 */
	private String getPigText() {
		String pigText = "";
		if (lastPrompt.equals("")) {
			pigText += pig.getPigPrint() + "\n\n";
			pigText += "\nQ: " + (MAXQUES - pig.getQuestion()) + "\t<3: " + pig.getFLevel() + "\n\n";
		}
		pigText += lastPrompt + "\n";
		pigText += getPromptList();
		
		return pigText;
	}
	
	
	/*
	 * Returns the prompts that the player is currently accessing
	 */
	private String getPromptList() {
		String response = "";
		for (String s: currentPrompt) {
			response += "   > " + s + "\n";
		}
		return response;
	}

	public String getPrompt() {
		return "GOPP";
	}

	/*
	 * Handles user input
	 */
	public String Handle(String s) {
		s = s.toLowerCase();
		// Checks if the prompt is a valid prompt
		if (currentPrompt.contains(s)) {
			
			// Checks if the prompt is an ending prompt
			if (pig.hasResponse(s)) {
				pig.addQuestion();
				// Resets prompts list
				lastPrompt = "";
				currentPrompt = basicPrompts;
				// Custom pig print
				String response = pig.getPigPrint() + "\n";
				response += pig.React(s);
				response += "\nQ: " + (MAXQUES - pig.getQuestion()) + "\t<3: " + pig.getFLevel() + "\n\n";
				response += pig.changeOrientation();
				
				
				// Checks to see if you either have a game over or a game win
				if (pig.getQuestion() >= MAXQUES || pig.getFLevel() >= MAXLEVEL || pig.getFLevel() <= LOWLEVEL) {
					String end = "";
					end += response + "\n\n";
					end += pig.getEndSpeech();
					// Resets
					currentPrompt = basicPrompts;
					lastPrompt = "";
					pig.resetPig();
					pig.changeFLevel(-pig.getFLevel());
					
					end += "GAME END\nPlay again?\n";
					end += pig.getBeginningSpeech() + "\n";
					end += getPromptList();
					
					return end;
				}
				else {
					response += getPromptList();
				}
				
				return response;
			}
			
			// If not a ending prompt, updates current prompts list
			lastPrompt += s + " ";
			setNewPrompt(s);
		}
		
		// Sets the prompt back on tier if "back" is typed
		else if (s.contains("back")) {
			setPromptBack();
		}
		
		// Prints if prompt is not valid
		// Simply pressing error allows the player to interact with pig
		// without an error message
		else
		{
			String response = "";
			if (!s.equals("")) {
				response += "Sorry, didn't quite get that";
			}
			response += "\n\n" + getPigText();
			return response;
		}
		
		return getPigText();
	}
	
	/*
	 * Takes the previous prompt that was typed in and, if that prompt is
	 * part of of the current prompts list sets the new prmpts list accordingly
	 */
	private void setNewPrompt(String s) {
		// Setting from the basic prompts
		if (s.equals("do you") && currentPrompt.equals(basicPrompts)) {
			currentPrompt = doPrompts;
		}
		if (s.equals("can you") && currentPrompt.equals(basicPrompts)) {
			currentPrompt = canPrompts;
		}
		if (s.equals("would you") && currentPrompt.equals(basicPrompts)) {
			currentPrompt = wouldPrompts;
		}
		if (s.equals("are you") && currentPrompt.equals(basicPrompts)) {
			currentPrompt = arePrompts;
		}
		
		// Setting from "do you" prompts
		if (s.equals("like") && currentPrompt.equals(doPrompts)) {
			currentPrompt = doLikePrompts;
		}
		if (s.equals("think") && currentPrompt.equals(doPrompts)) {
			currentPrompt = doThinkPrompts;
		}
		if (s.equals("believe in") && currentPrompt.equals(doPrompts)) {
			currentPrompt = doBelievePrompts;
		}
		
		
		// Setting from "can you" prompts
		if (s.equals("tell me") && currentPrompt.equals(canPrompts)) {
			currentPrompt = canTellPrompts;
		}
		if (s.equals("give me") && currentPrompt.equals(canPrompts)) {
			currentPrompt = canGivePrompts;
		}
		if (s.equals("do") && currentPrompt.equals(canPrompts)) {
			currentPrompt = canDoPrompts;
		}

		// Setting from "would you" prompts
		if (s.equals("like to") && currentPrompt.equals(wouldPrompts)) {
			currentPrompt = wouldLikePrompts;
		}
		if (s.equals("go to") && currentPrompt.equals(wouldPrompts)) {
			currentPrompt = wouldGoPrompts;
		}
		
		// Setting from "are you" prompts
		if (s.equals("good at") && currentPrompt.equals(arePrompts)) {
			currentPrompt = areGoodPrompts;
		}
		if (s.equals("scared of") && currentPrompt.equals(arePrompts)) {
			currentPrompt = areScaredPrompts;
		}
		if (s.equals("actually") && currentPrompt.equals(arePrompts)) {
			currentPrompt = areActuallyPrompts;
		}
	}
	
	private void setPromptBack() {
		// Setting to the basic prompts
		if (currentPrompt.equals(doPrompts) || currentPrompt.equals(canPrompts) ||
				currentPrompt.equals(wouldPrompts) || currentPrompt.equals(arePrompts)) {
			currentPrompt = basicPrompts;
			lastPrompt = "";
		}
		
		// Setting to "do you" prompts
		if (currentPrompt.equals(doLikePrompts) || currentPrompt.equals(doThinkPrompts) ||
				currentPrompt.equals(doBelievePrompts)) {
			currentPrompt = doPrompts;
			lastPrompt = "do you ";
		}
		
		
		// Setting to "can you" prompts
		if (currentPrompt.equals(canTellPrompts) || currentPrompt.equals(canGivePrompts) ||
				currentPrompt.equals(canDoPrompts)) {
			currentPrompt = canPrompts;
			lastPrompt = "can you ";
		}

		// Setting to "would you" prompts
		if (currentPrompt.equals(wouldLikePrompts) || currentPrompt.equals(wouldGoPrompts)) {
			currentPrompt = wouldPrompts;
			lastPrompt = "would you ";
		}
		
		// Setting to "are you" prompts
		if (currentPrompt.equals(areGoodPrompts) || currentPrompt.equals(areScaredPrompts) ||
				currentPrompt.equals(areActuallyPrompts)) {
			currentPrompt = arePrompts;
			lastPrompt = "are you ";
		}
	}

	public String Exit() {
		return "Fine, Pig didn't want to talk with either";
	}

}
