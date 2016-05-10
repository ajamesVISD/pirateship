package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.minigame.text.*;

/**
 * A 
 * @author andy
 *
 */
public abstract class Minigame extends Actor {
	
	Response response;
	String exitWord;
	
	public static Minigame produce(String s) {
		TextMinigameFactory m;
		if (s.equalsIgnoreCase("20Q")) {
			m = new TwentyQuestionsFactory();
		} else if (s.equalsIgnoreCase("Blackjack")) {
			m = new BlackjackFactory();
		} else if (s.equalsIgnoreCase("CC")) {
			m = new CookieClickerFactory();
		} else if (s.equalsIgnoreCase("GF")) {
			m = new GoFishFactory();
		} else if (s.equalsIgnoreCase("GuessCalc")){
			m = new GuessingCalculatorFactory();
		} else if (s.equalsIgnoreCase("math")) {
			m = new MathFactory();
		} else if (s.equalsIgnoreCase("GOPP")) {
			m = new PrisonEscapeFactory();
		} else if (s.equalsIgnoreCase("Shot")) {
			m = new ShotgunFactory();
		} else if (s.equalsIgnoreCase("Tic tac toe")) {
			m = new TicTacToeFactory();
		}
		else {
			m = null;
		}
		return new TextMinigameAdapter(m);
	}

	public Minigame(String name, String typeName, String description, String splash) {
		super(name, typeName, description, " " + splash + "[" + typeName + "]");
		response = new Response();
		response.setKeepAlive(true);
		response.setTarget(this);
		//response.setText(getGreeting());
		this.exitWord = "exit";
	}
	
	public Response quit() {
		Response r = new Response(getExit());
		return r;
	}

	/**
	 * You get the keys to the handle method. Drive safely.
	 * 
	 * Use req.getVerb() to find out what action phrase has been sent to you.
	 * Use req.getPlayer() to get the player that made the request.
	 */
	@Override
	public Response handle(Request req) {
		if (req.getText().equalsIgnoreCase(exitWord)) {
			return quit();
		} else {
			return handleOtherwise(req);
		}
	}
	
	public abstract String getGreeting();
	
	public abstract Response handleOtherwise(Request req);
	
	public abstract String getPrompt();
	
	public abstract String getExit();
}
