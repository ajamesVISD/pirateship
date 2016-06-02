package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.creature.Creature;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

public class Interactions extends Minigame {
	
	Creature c;
	
	public Interactions(Creature c) {
		super("", "interact", "", "");
		this.c = c;
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
		commands += "> Talk    > Give    > Take\n";
		commands += " >Exit\n";
		
		return commands;
	}
	
	
	/**
	 * Deals with user input
	 */
	@Override
	public Response handleOtherwise(Request req) {
		String prompt = req.getText();
		String text = "";
		if (prompt.equalsIgnoreCase("talk")) {
			text += c.getSpeechBehavior().speak(c);
			text += getTurnText();
		} else if (prompt.equalsIgnoreCase("give")) {
			
		} else if (prompt.equalsIgnoreCase("take")) {
			
		} else if (prompt.equals("")){
			text += "You stare at " + c.getName() + ".";
			text += getTurnText();
		} else {
			text += c.getSpeechBehavior().failText(c);
			text += getTurnText();
		}
		this.response.setText(text);
		return this.response;
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
		return c.getSpeechBehavior().exit(c);
	}
}
