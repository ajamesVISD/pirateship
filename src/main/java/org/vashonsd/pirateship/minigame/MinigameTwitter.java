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
		return "Here are the latest tweets from a specific user:";
	}

	public String getPrompt() {
		return "Twitter";
	}

	public String Handle(String s) {
		String toReturn = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Insert the username of the user: ");
		String username = "VHSPirates";
		try {
			username = "" + in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not parse the username. Printing the tweets of Vashon Island High School");
		}
		
		final Twitter twitter2 = new TwitterFactory().getInstance();
	    List<Status> statuses2 = null;
		try {
			statuses2 = twitter2.getUserTimeline(username);
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println("Couldn't find any tweet");
		}

	    for (Status status : statuses2) {
	        toReturn +=("@" + status.getUser().getScreenName() + " - " + status.getText() + "\n");
	    }
		return toReturn;
	}

	public String Exit() {
		return "Thanks for playing, you mind reader you.";
	}

}
