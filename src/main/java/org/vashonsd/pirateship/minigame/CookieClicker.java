package org.vashonsd.pirateship.minigame;

import java.util.*;
import java.util.Random;

public class CookieClicker implements Minigame {
	private double cookies;
	private double cookiesPerSecond;
	private int lastTime;
	
	public Buildings[] buildings = { 
		    new Buildings("clicker", 0.1, 15, 0), new Buildings("grandma", 1.0, 100, 0), 
		    new Buildings("farm", 10.0, 500, 0), new Buildings("factory", 10.0, 1000, 0)
		};
	
	public CookieClicker(){
		super();
		setUpGame();
	}
	
	private void setUpGame() {
		cookies = 0;
		cookiesPerSecond = 0;
		lastTime = (int) System.currentTimeMillis();
	}

	public String Run() {
		return "Type 'click cookie' to gain a cookie";
	}

	public String Handle(String c) {
		// TODO Auto-generated method stub
		if(c.equalsIgnoreCase("click cookie"))
		{
			cookies += 1;
		}
		
		cookies += secondsPast()*cookiesPerSecond;
		
		for(int i = 0; i < buildings.length; i++)
		{
			if(c.equalsIgnoreCase(buildings[i].getName()))
			{
				if(cookies >= buildings[i].getCost())
				{
					cookies -= (buildings[i].getCost());
					buildings[i].addAmount(1);
					cookiesPerSecond += buildings[i].getCps();
					buildings[i].setCost((int)(buildings[i].getCost()*1.15));
					
				}
				else
				System.out.println("you cannot aford this item");
				System.out.println("you have " + buildings[i].getAmount() + " " + buildings[i].getName());

			}
		}
//		if(c.equalsIgnoreCase("buy clicker"))
//		{
//			if(cookies >= clickerPrice)
//			{
//				cookies -= (clickerPrice);
//				clickers += 1;
//				cookiesPerSecond += 0.1;
//				clickerPrice = (15 + clickers*clickers);
//			}
//			else
//			System.out.println("you cannot aford a new clicker");
//			
//			System.out.println("you have " + clickers + " clickers");
//		}
		for(int i = 0; i < buildings.length; i++)
		{
			System.out.println(buildings[i]);
		}
		
		return "you have " + (int)cookies + " cookies";
	}
	
	public double secondsPast()
	{
		int t = (int)System.currentTimeMillis();
		t = t - lastTime;
		double x = (double)t;
		x = x/1000;
		lastTime = (int)System.currentTimeMillis();
		return x;
	}
	
	public void addCookies(double x)
	{
		cookies += x;
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing! You ended with " + cookies + " cookies";
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "CC";
	}

}