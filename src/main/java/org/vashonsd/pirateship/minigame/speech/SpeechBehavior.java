package org.vashonsd.pirateship.minigame.speech;

import java.util.*;

public interface SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	/*
	 * Returns simple string response to a question asked
	 * by the player
	 */
	public String getResponse(String s);
	
	/*
	 * Returns the change in fLevel for any given question
	 */
	public int getFLevelChange(String s);

	/*
	 * Sets the fLevel change for a response to 0
	 */
	public void voidFLevel(String s);
	
	/*
	 * Returns HashMap
	 */
	public HashMap<String, String> getPrompts();
	
	/*
	 * Returns the intro
	 */
	public String getIntro();
	
	/*
	 * Returns outro, aka the text spoken when pig releases you
	 */
	public String getOutro();
	
	/*
	 * Initializes the speech
	 */
	public void setPigSpeech();
	
	/*
	 * Personalities that may be included:
	 * Sassy (thinks they're very cool, sarcastic), CHECK
	 * Boring (dull, unopinionated, just likes praise),
	 * Jock (competative, likes actiony things),
	 * Nerd (sci fi, kinda bossy?), Geek (likes science and math),
	 * Shy (quiet, likes occultist stuff),
	 * Eccentric (believes in MAGIC, maybe likes conspiricies?),
	 * Lazy (lazy) CHECK
	 */
	/*
	// "do you like"
	responsePrompts.put("food", "");	
	fLevelChange.put("food", 0);
	responsePrompts.put("sci fi", "");
	fLevelChange.put("sci fi", 0);
	responsePrompts.put("the superbowl", "");
	fLevelChange.put("the superbowl", 0);
	responsePrompts.put("long graduation speeches", "");	
	fLevelChange.put("long graduation speeches", 0);
	responsePrompts.put("all things", "");	
	fLevelChange.put("all things", 0);
	responsePrompts.put("voodoo", "");	
	fLevelChange.put("voodoo", 0);
	responsePrompts.put("putting people in their place", "");	
	fLevelChange.put("putting people in their place", 0);
	// "do you think"
	responsePrompts.put("i'm pretty", "");	
	fLevelChange.put("i'm pretty", 0);
	responsePrompts.put("you're pretty", "");	
	fLevelChange.put("you're pretty", 0);
	responsePrompts.put("you're cool", "");	
	fLevelChange.put("you're cool", 0);
	responsePrompts.put("the end is nigh", "");	
	fLevelChange.put("the end is nigh", 0);
	responsePrompts.put("we're in the matrix", "");	
	fLevelChange.put("we're in the matrix", 0);
	responsePrompts.put("the government is made of alien lizards", "");	
	fLevelChange.put("the government is made of alien lizards", 0);
	// "do you believe in"
	responsePrompts.put("ghosts", "");	
	fLevelChange.put("ghosts", 0);
	responsePrompts.put("the force", "");	
	fLevelChange.put("the force", 0);
	responsePrompts.put("dumbledore", "");	
	fLevelChange.put("dumbledore", 0);
	responsePrompts.put("believing in things", "");	
	fLevelChange.put("believing in things", 0);
	responsePrompts.put("the moon", "");	
	fLevelChange.put("the moon", 0);
	responsePrompts.put("honest work", "");	
	fLevelChange.put("honest work", 0);
	responsePrompts.put("dumb luck", "");	
	fLevelChange.put("dumb luck", 0);
	responsePrompts.put("sleeping in", "");	
	fLevelChange.put("sleeping in", 0);
	// "can you tell me"
	responsePrompts.put("a joke", "");	
	fLevelChange.put("a joke", 0);
	responsePrompts.put("a secret", "");	
	fLevelChange.put("a secret", 0);
	responsePrompts.put("an idea", "");	
	fLevelChange.put("an idea", 0);
	responsePrompts.put("some gossip", "");	
	fLevelChange.put("some gossip", 0);
	responsePrompts.put("the meaning of life", "");	
	fLevelChange.put("the meaning of life", 0);
	responsePrompts.put("something cool", "");	
	fLevelChange.put("something cool", 0);
	responsePrompts.put("somethign weird", "");	
	fLevelChange.put("something weird", 0);
	responsePrompts.put("something", "");	
	fLevelChange.put("something", 0);
	// "can you give me"
	responsePrompts.put("something to eat", "");	
	fLevelChange.put("something to eat", 0);
	responsePrompts.put("a smile", "");	
	fLevelChange.put("a smile", 0);
	responsePrompts.put("advice", "");	
	fLevelChange.put("advice", 0);
	responsePrompts.put("a club penguin membership", "");	
	fLevelChange.put("a club penguin membership", 0);
	responsePrompts.put("a sweet hotwheels collection", "");	
	fLevelChange.put("a sweet hotwheels collection", 0);
	responsePrompts.put("your hand in marriage", "");	
	fLevelChange.put("your hand in marriage", 0);
	// "can you do"
	responsePrompts.put("a backflip", "");	
	fLevelChange.put("a backflip", 0);
	responsePrompts.put("magic", "");	
	fLevelChange.put("magic", 0);
	responsePrompts.put("a perfect gilbert gottfried impression", "");	
	fLevelChange.put("a perfect gilbert gottfried impression", 0);
	responsePrompts.put("a tumblr", "");	
	fLevelChange.put("a tumblr", 0);
	responsePrompts.put("pi", "");	
	fLevelChange.put("pi", 0);
	responsePrompts.put("murder", "");	
	fLevelChange.put("murder", 0);
	responsePrompts.put("absolutely nothing", "");	
	fLevelChange.put("absolutely nothing", 0);
	// "would you like to"
	responsePrompts.put("watch tv with me", "");	
	fLevelChange.put("watch tv with me", 0);
	responsePrompts.put("build a snowman", "");	
	fLevelChange.put("build a snowman", 0);
	responsePrompts.put("take over the world", "");	
	fLevelChange.put("take over the world", 0);
	responsePrompts.put("get a life", "");	
	fLevelChange.put("get a life", 0);
	responsePrompts.put("go to the bathroom", "");	
	fLevelChange.put("go to the bathroom", 0);
	responsePrompts.put("lay on the ground and feel like trash", "");	
	fLevelChange.put("lay on the ground and feel like trash", 0);
	// "would you go to"
	responsePrompts.put("mars", "");	
	fLevelChange.put("mars", 0);
	responsePrompts.put("the caribbean", "");	
	fLevelChange.put("the caribbean", 0);
	responsePrompts.put("narnia", "");	
	fLevelChange.put("narnia", 0);
	responsePrompts.put("the internets", "");	
	fLevelChange.put("the internets", 0);
	responsePrompts.put("your room", "");	
	fLevelChange.put("your room", 0);
	responsePrompts.put("my funeral", "");	
	fLevelChange.put("my funeral", 0);
	// "are you good at"
	responsePrompts.put("sports", "");	
	fLevelChange.put("sports", 0);
	responsePrompts.put("the arts", "");	
	fLevelChange.put("the arts", 0);
	responsePrompts.put("brain stuff", "");	
	fLevelChange.put("brain stuff", 0);
	responsePrompts.put("being cool", "");	
	fLevelChange.put("being cool", 0);
	responsePrompts.put("breathing", "");	
	fLevelChange.put("breathing", 0);
	responsePrompts.put("procrastinating", "");	
	fLevelChange.put("procrastinating", 0);
	responsePrompts.put("over-analyzing", "");	
	fLevelChange.put("over-analyzing", 0);
	responsePrompts.put("everything", "");	
	fLevelChange.put("everything", 0);
	// "are you scared of"
	responsePrompts.put("clowns", "");	
	fLevelChange.put("clowns", 0);
	responsePrompts.put("losing", "");	
	fLevelChange.put("losing", 0);
	responsePrompts.put("idiots", "");	
	fLevelChange.put("idiots", 0);
	responsePrompts.put("gilbert gottfried", "");	
	fLevelChange.put("gilbert gottfried", 0);
	responsePrompts.put("insomnia", "");	
	fLevelChange.put("insomnia", 0);
	responsePrompts.put("the dark side", "");	
	fLevelChange.put("the dark side", 0);
	responsePrompts.put("public speaking", "");	
	fLevelChange.put("public speaking", 0);
	responsePrompts.put("people knowing how dead you are inside", "");	
	fLevelChange.put("people knowing how dead you are inside", 0);
	// "are you actually"
	responsePrompts.put("a zombie", "");	
	fLevelChange.put("a zombie", 0);
	responsePrompts.put("a unicorn", "");	
	fLevelChange.put("a unicorn", 0);
	responsePrompts.put("a sloth", "");	
	fLevelChange.put("a sloth", 0);
	responsePrompts.put("a smartass", "");	
	fLevelChange.put("a smartass", 0);
	responsePrompts.put("a jedi master", "");	
	fLevelChange.put("a jedi master", 0);
	responsePrompts.put("a gilbert gottfried", "");	
	fLevelChange.put("a gilbert gottfried", 0);
	responsePrompts.put("the devil himself", "");	
	fLevelChange.put("the devil himself", 0);
	responsePrompts.put("a lizard person", "");	
	fLevelChange.put("a lizard person", 0);
	*/
}
