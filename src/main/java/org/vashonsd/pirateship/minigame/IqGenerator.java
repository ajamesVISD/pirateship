package org.vashonsd.pirateship.minigame;

import java.util.*;
import java.util.Random;


public class IqGenerator implements Minigame {
	ArrayList<String> questions;
	public String Run() {
		// TODO Auto-generated method stub
		questions = new ArrayList<String>();
		return "Ready to find out how smart you are?";
		
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "IQ";
	}

	public String Handle(String s) {
		// TODO Auto-generated method stub
		Random r = new Random();

		
		int yourIq = r.nextInt(163);
				
		
		if(yourIq <= 25)
		{
			s = "Your IQ is " + yourIq + " \nClown College For You!";
			
			return s;
		}
		else if(yourIq > 25 && yourIq <= 75)
		{
			s = "Your IQ is " + yourIq + " \nWell you have to start somewhere!";
			return s;
		}
		else if(yourIq > 75 && yourIq <= 100)
		{
			s = "Your IQ is " + yourIq + " \nYou an average Joe";
			return s;
		}
		else if(yourIq > 100 && yourIq <= 125)
		{
			s = "Your IQ is " + yourIq + " \nI can see success in your future!";
			return s;
		}
		else if(yourIq > 125 && yourIq <= 150)
		{
			s = "Your IQ is " + yourIq + " \nYou have earned Alden's Respect!";
			return s;
		}
		else if(yourIq > 150 && yourIq <= 161)
		{
			s = "Your IQ is " + yourIq + " \nYou are a genius!";
			return s;
		}
		else 
		{
			s = "Your IQ is " + yourIq + " \nYou are the smartest person on the planet!";
			return s;
		}

	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Hope you are ok with your IQ cause you're stuck with it!";
	}

}
