package org.vashonsd.pirateship.minigame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinigameRunner {
	
	private static MinigameRuntime rt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		rt = new MinigameRuntime();
		printGreeting();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			if (!(rt.hasReceiver())) {
				printGreeting();
			}
			String input = in.readLine();
			if (!(rt.hasReceiver()) && input.equals("exit")) {
				System.out.println("All done. Goodbye.");
				break;
			} else {
				//pass it to the runtime.
				System.out.println(rt.handle(input));
			}
		}
	}
	
	public static void printGreeting() {
		System.out.println("Available programs:");
		System.out.println(rt.showGames());
	}
}
