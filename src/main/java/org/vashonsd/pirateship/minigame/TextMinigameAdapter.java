package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.minigame.text.TextMinigame;
import org.vashonsd.pirateship.minigame.text.TextMinigameFactory;

public class TextMinigameAdapter extends Minigame {
	
	TextMinigame minigame;
	Response response;

	public TextMinigameAdapter(TextMinigameFactory factory) {
		super(factory.getFullName(), factory.getName(), factory.getDescription(), factory.getDescription());
		this.minigame = factory.newGame();
		response = new Response();
		//by default, the keepAlive value is set to true.
		response.setKeepAlive(true);
		//and this is the persistent target for the Player.
		response.setTarget(this);
		response.setText(minigame.Run());
	}
	
	public Response handleOtherwise(Request req) {
		response.setText(minigame.Handle(req.getText()));
		return response;
	}

	@Override
	public String getGreeting() {
		return minigame.Run();
	}

	@Override
	public String getPrompt() {
		return minigame.getPrompt();
	}

	@Override
	public String getExit() {
		return minigame.Exit();
	}
}
