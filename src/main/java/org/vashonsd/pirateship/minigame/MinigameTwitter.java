package org.vashonsd.pirateship.minigame;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.*;

public class MinigameTwitter implements Minigame {

	public MinigameTwitter() {
		super();
	}

	public String Run() {
		return "Here are the latest tweets from VHSPirateShip:";
	}

	public String getPrompt() {
		return "Twitter";
	}

	public String Handle(String s) throws TwitterException, IOException {
		String toReturn = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Insert the username of the user: ");
		String username = "" + in.readLine();
		
		final Twitter twitter2 = new TwitterFactory().getInstance();
	    final List<Status> statuses2 = twitter2.getUserTimeline(username);

	    for (Status status : statuses2) {
	        toReturn +=("@" + status.getUser().getScreenName() + " - " + status.getText() + "\n");
	    }
		return toReturn;
	}

	public String Exit() {
		return "Thanks for playing, you mind reader you.";
	}

}
