package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.creature.Creature;
import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

public class Interactions extends Minigame {
	
	Creature c;
	Player player;
	private int menu;
	private int blankClick;
	private MinigameRunner run;
	
	public static int MAIN_MENU = 0;
	public static int GIVE = 1;
	public static int TAKE = 2;
	
	public static int MAX_CLICKS = 10;
	
	
	public Interactions(Creature c, Player player) {
		super("", "interact", "", "");
		this.c = c;
		this.player = player;
		menu = MAIN_MENU;
		blankClick = 0;
	}
	
	public void setMinigameRunner(MinigameRunner run) {
		this.run = run;
	}

	/** Text that displays on first turn
	 * (Displays approach text rather than idle text)
	 */
	@Override
	public String getGreeting() {
		String text = "";
		text += c.getSpeechBehavior().approach(c) + "\n";
		text += getCommandsMenu();
		
		return text;
	}


	/**
	 * Default text that displays every turn
	 */
	private String getTurnText() {
		String text = "";
		text += "\n\n" + c.getSpeechBehavior().idle(c) + "\n";
		text += getCommandsMenu();
		
		return text;
	}
	
	/**
	 * List of commands the player can take
	 */
	private String getCommandsMenu() {
		String commands = "";
		commands += "\nCommands:\n";
		commands += "> Check    > Talk\n";
		commands += " > Give     > Take\n";
		commands += "> Exit\n";
		
		return commands;
	}
	
	
	/**
	 * Deals with user input
	 */
	@Override
	public Response handleOtherwise(Request req) {
		String prompt = req.getText();
		String text = "";
		if (menu == MAIN_MENU) {
			text += processMainMenu(prompt);
		} else if (menu == GIVE) {
			text += processGiveMenu(prompt);
			menu = MAIN_MENU;
		} else if (menu == TAKE) {
			text += processTakeMenu(prompt);
			menu = MAIN_MENU;
		} else {
			text += "I'm not sure how you got this, unless you're a hacker.\n";
			menu = MAIN_MENU;
		}
		
		this.response.setText(text);
		return this.response;
	}
	
	/**
	 * Processes any prompts given to the main menu
	 */
	private String processMainMenu(String prompt) {
		String text = "";
		if (prompt.equalsIgnoreCase("check")) {
			blankClick = 0;
			text += c.getName() + " the " + c.getTypeName() + "\n";
			text += c.getDescription() + "\n";
			text += "HP: " + c.getHealth() + "/" + c.getMaxHealth() + "\n";
			text += "ATK: " + c.getAttack() + "    DEF: " + c.getDefense();
			return text;
		} else if (prompt.equalsIgnoreCase("talk")) {
			blankClick = 0;
			text += c.getSpeechBehavior().speak(c);
			return text;
		} else if (prompt.equalsIgnoreCase("give")) {
			blankClick = 0;
			if (!player.getInventory().isEmpty()) {
				text += "What would you like to give?\n\n";
				text += player.getInventory().toString();
				menu = GIVE;
			} else {
				text += "You don't have anything to give.";
			}

			return text;
		} else if (prompt.equalsIgnoreCase("take")) {
			blankClick = 0;
			if (!c.getInventory().isEmpty()) {
				text += "What would you like to take?\n\n";
				text += c.getInventory().toString();
				menu = TAKE;
			} else {
				text += c.getName() + " doesn't have anything to take.";
			}

			return text;
		} else if (prompt.equals("")){
			blankClick++;
			if (blankClick >= MAX_CLICKS) {
				blankClick = 0;
				text += c.getName() + " is uncomfortable with all the clicking you're doing";
			}
		} else {
			blankClick = 0;
			text += c.getSpeechBehavior().failText(c);
		}
		
		text += getTurnText();
		return text;
	}
	
	/**
	 * Processes any prompts given to the Give menu
	 */
	private String processGiveMenu(String prompt) {
		String text = "";
		if (player.getInventory().hasByTypeName(prompt)) {
			text += "You give the " + prompt + " to " + c.getName() + ".\n";
			Actor a = player.getInventory().getByTypeName(prompt);
			player.removeFromInventory(a);
			c.addToInventory(a);;
			text += c.checkHoldingEffect(a);
		} else if (prompt.equals("")) {
			text += "You decide to stare awkwardly at " + c.getName() + " rather than give anything.\n";
			text += c.getName() + " is uncomfortable.";
		} else {
			text += "You don't have a " + prompt + " to give.";
		}
		return text;
	}
	
	/**
	 * Processes any prompts given to the Take menu
	 */
	private String processTakeMenu(String prompt) {
		String text = "";
		if (c.getInventory().hasByTypeName(prompt)) {
			text += "You take the " + prompt + " from " + c.getName() + ".\n";
			Actor a = c.getInventory().getByTypeName(prompt);
			c.removeFromInventory(a);
			player.addToInventory(a);
			text += c.refreshHoldingEffects();
		} else {
			text += c.getName() + " doesn't have a " + prompt + " to take.";
		}
		return text;
	}
	
	@Override
	public String getPrompt() {
		return null;
	}

	/**
	 * Text that displays upon leaving
	 */
	@Override
	public String getExit() {
		player.getLocation().removeFromInventory(run);
		return c.getSpeechBehavior().exit(c) + "\n";
	}
}
