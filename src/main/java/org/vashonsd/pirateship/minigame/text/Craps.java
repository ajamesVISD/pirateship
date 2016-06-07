package org.vashonsd.pirateship.minigame.text;

import java.util.Random;

public class Craps implements TextMinigame{

	private int o;
	private int t;
	private int theRoll;
	private int firstRoll;
	private static String finish = "\nType 'first roll to play again.";
	
	private static String rules = "Type 'first roll' to roll first and recieve your point."
			+ "\nAfter your roll, you may type 'roll' to keep rolling or you may type 'exit' to leave."
			+ "\nOn your first roll, if you get a 7 or an 11, you win instantly."
			+ "\nBut if you roll a 2, 3, or a 12 on your first roll, you lose."
			+ "\nAfter your first roll, your goal is to hit the point. If you do you win."
			+ "\nIf you get a 7, you lose."
			+ "\n Type 'first roll' to begin.";
	
	public Craps() {
		super();
		setUp();
	}
	
	public String Run() {
		return "Type 'first roll' to roll the dice."
				+ "\nIf you don't crap out or pass, keep typing 'roll' until you hit the point or hit a 7."
				+ "\nType 'rules' to see the rules.";
	}
	
	public void setUp() {
		Random dieOne = new Random();
		Random dieTwo = new Random();
		int dOne = dieOne.nextInt(5);
		o = dOne+1;
		int dTwo = dieTwo.nextInt(5);
		t = dTwo+1;
		theRoll = o + t;
	}

	public String getPrompt() {
		return "craps";
	}

	public String Handle(String s) {
		int i;
		String result = "";
		for(i=0; i<=0; i++)
			if(i==0)
				firstRoll = theRoll;
		int point;
		if(s.equals("rules")) {
			System.out.println(rules);
		}
		if(s.equals("first roll")) {
			point = firstRoll;
			System.out.println("The point is " + point);
			if(point == 2 || point == 3 || point == 12) {
				result = "You rolled a " + point + ", you lost." + finish;
				i=0;
				setUp();
			} 
			if(point == 7 || point == 11) {
				result = "You rolled a " + point + ", you won." + finish;
				i=0;
				setUp();
			}
		}
		if(s.equals("roll")) {
			point=firstRoll;
			if(theRoll == point) {
				result = "You rolled a " + theRoll + ", you won." + finish;
				i=0;
				setUp();
			} if(theRoll == 7) {
				result = "You rolled a 7, you lost " + finish;
				i=0;
				setUp();
			} else {
				result = "You rolled a " + theRoll + ", roll again.";
			}
		}
		return result;
	}

	public String Exit() {
		return "Thanks for playing";
	}

}
