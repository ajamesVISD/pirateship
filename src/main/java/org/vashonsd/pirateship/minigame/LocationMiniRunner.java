package org.vashonsd.pirateship.minigame;

public class LocationMiniRunner 
{
	private Registry r;
	private static MinigameRuntime rt;
	
	public LocationMiniRunner(Registry r)
	{
		this.r = r;
	}
	
	public String Run(String s)
	{
		rt = new MinigameRuntime(r);
		
		if (!(rt.hasReceiver())) {
			printGreeting();
		}
		String input = s;
		if (!(rt.hasReceiver()) && input.equals("exit")) 
		{
			return "Thanks for playing! Goodbye.";
		} else {
			//pass it to the runtime.
			return rt.handle(input);
		}

	}
	
	public static void printGreeting() {
		System.out.println("Available games:");
		System.out.println(rt.showGames());
	}
}
