package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

public class IdioticGame extends Minigame {
	
	int wordsSaid;

	public IdioticGame() {
		super("Idiotic Game", "idiotic", "Not even a game, just a demo", "Come play this foolish game!");
		wordsSaid = 0;
	}

	@Override
	public String getGreeting() {
		return "Hey there! Say anything you want, I'll keep count!";
	}

	@Override
	public String getPrompt() {
		return "idiot";
	}

	@Override
	public String getExit() {
		return "Well, that was fun! Thanks for saying " + this.wordsSaid + " to me.";
	}

	@Override
	public Response handleOtherwise(Request req) {
		int count = req.getText().split(" ").length;
		wordsSaid += count;
		this.response.setText("That was " + count + " words. You've said " + this.wordsSaid + " words so far!");
		return response;
	}
}
