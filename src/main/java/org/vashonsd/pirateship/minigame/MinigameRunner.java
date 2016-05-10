package org.vashonsd.pirateship.minigame;

import java.util.HashMap;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

public class MinigameRunner extends Actor {

	HashMap<String, Minigame> games;
	
	//This is the word we will use to launch the game. "Play" by default.
	String playWord;
	String minigameType;
	
	//This is an example instance of the Minigame for this Runner.
	Minigame model;
	
	/**
	 * By default, this kind of runner gets its name from the sample Minigame you send it.
	 * However, feel free to override this constructor to create, say, a creature that wants to announce a battle of wits.
	 * @param game
	 */
	public MinigameRunner(String game) {
		super("","","","");
		model = Minigame.produce(game);
		if (model == null) {
			throw new NullPointerException();
		} else {
			//We do not set the name for this until we know it is successful.
			this.minigameType = game;
			this.setName(model.getName());
			this.setTypeName(model.getTypeName());
			this.setDescription(model.getDescription());
			this.setSplashText(model.getSplashText());
		}
		this.games = new HashMap<String, Minigame>();
		this.playWord = "play";
	}
	
	@Override
	public Response handle(Request req) {
		Player player = req.getPlayer();
		String id = player.getId();
		String result = "";
		Minigame game = null;
		if (req.getVerb().equalsIgnoreCase(playWord) || req.getVerb().isEmpty()) {
			if (games.containsKey(id)) {
				game = games.get(id);
				result += game.getPrompt() + ": " + "Welcome back, " + player.getName() + "!\n";
			} else {
				game = Minigame.produce(minigameType);
				//result += game.getGreeting() + "\n";
				games.put(id, game);
			}
		} else {
			return new Response("I'm not sure what you want here.");
		}
		result += game.getGreeting() + "\n";
		Response resp = new Response(result);
		resp.setTarget(game);
		return resp;
	}
}
