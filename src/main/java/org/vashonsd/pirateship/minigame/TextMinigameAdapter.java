package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.minigame.text.TextMinigame;

public class TextMinigameAdapter extends Minigame {
	
	TextMinigame minigame;
	Response response;

	public TextMinigameAdapter(TextMinigame t) {
		super(t.getPrompt(), t.getPrompt(), "", "");
		this.minigame = t;
		response = new Response();
		//by default, the keepAlive value is set to true.
		response.setKeepAlive(true);
		//and this is the persistent target for the Player.
		response.setTarget(this);
		response.setText(minigame.Run());
	}

	@Override
	public Response handle(Request req) {
		String prompt = minigame.getPrompt() + ": ";
		if (req.getText().equals("exit")) {
			response.setText(prompt + minigame.Exit());
		} else {
			response.setText(prompt + minigame.Handle(req.getText()));
		}
		return response;
	}

	@Override
	public String greet() {
		return minigame.Run();
	}

	@Override
	public String prompt() {
		return minigame.getPrompt();
	}

	@Override
	public String exit() {
		return minigame.Exit();
	}
}
