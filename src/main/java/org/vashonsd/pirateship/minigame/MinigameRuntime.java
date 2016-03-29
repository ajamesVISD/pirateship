/**
 * 
 */
package org.vashonsd.pirateship.minigame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author andy
 * This makes a runtime in which to test out minigames. This avoids the chore of handling static methods
 * and, if we like, allows us to pass different I/O environments to the runtime.
 */
public class MinigameRuntime {
	private Minigame receiver;
	private Registry r;
	
	public MinigameRuntime() {
		super();
		r = new Registry();
		//By default, we'll use the console in as input. If we want to set a different input later, we can.
	}
	
	public String showGames() {
		return r.toString();
	}
	
	public boolean hasReceiver() {
		return (receiver != null);
	}
	
	private String prompted(String s) {
		return receiver.getPrompt() + "> " + s;
	}

	public String handle(String input) {
		// Our first condition: We don't have a runtime set for any minigame. Time to see if
		// have been sent a valid choice for one.
		if (receiver == null) {
			if (r.hasGame(input)) {
				receiver = r.getGame(input);
				return prompted(receiver.Run());
			} else {
				return input + " is not a valid choice. Please try again.";
			}
		}
		
		//Now we know we hava a Minigame set as a receiver for commands.
		//First, if the minigame gets the signal "exit," it's time to quit.
		if (input.equals("exit")) {
			String result = prompted(receiver.Exit());
			receiver = null;
			return result;
		}
		//Otherwise, send back whatever the receiver does with the input.
		return prompted(receiver.Handle(input));
	}
}