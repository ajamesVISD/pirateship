package org.vashonsd.pirateship.minigame.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class MinigameTwitter implements TextMinigame {

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
		
		
		for(int i=0; i<username.length(); i++)
		{
			if(username.charAt(i) == ' ')
			{
				System.out.println("could not parse the username. Printing the tweets of Vashon Island High School...");
				username = "VHSPirates";
			}
		}
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey("xHME9MIFTv9urEML81fMVHNF8");
		builder.setOAuthConsumerSecret("LJfdZz3eEWpdNMpm9IM6aHQqVYhDnoiagY3PXLsWdPfQi7IEeD");
		builder.setOAuthAccessToken("1150435278-RHg39jKA1zWTp5dMy2zIkClXwSiDe1ff70Ar4k5");
		builder.setOAuthAccessTokenSecret("qVLy4ThfZZdME1W5TVI2em98SyBXWwzJsyEi64OgcY0kK");
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		final Twitter twitter2 = factory.getInstance();
		
		
	    List<Status> statuses2 = null;
		try {
			statuses2 = twitter2.getUserTimeline(username);
		} catch (TwitterException e) {
			if(e.getStatusCode() == 404)
			{
				username = "VHSPirates";
				System.out.println("The username does not exist. Printing the tweets of Vashon Island High School...\n");
			}
		}
		
		statuses2 = null;
		try {
			statuses2 = twitter2.getUserTimeline(username);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
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
