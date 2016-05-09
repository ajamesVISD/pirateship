package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.minigame.text.Registry;

public class LocationMiniRunner 
{
	private Registry r;
	private static MinigameRuntime rt;
	
	public LocationMiniRunner(Registry r)
	{
		this.r = r;
		rt = new MinigameRuntime(r);
	}
	
	public String Run(String s)
	{
		String input = s;
		if (!(rt.hasReceiver()) && input.equals("exit")) 
		{
			return "Thanks for playing! Goodbye.";
		} else {
			//pass it to the runtime.
			return rt.handle(input);
		}

	}
	
	public String printGreeting() {
		return "Available games: \n" + rt.showGames();
	}
}
