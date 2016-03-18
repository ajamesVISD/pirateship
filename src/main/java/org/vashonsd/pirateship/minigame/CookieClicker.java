package org.vashonsd.pirateship.minigame;

import java.util.*;
import java.util.Random;

public class CookieClicker implements Minigame {
	private double cookies;
	private double cookiesPerSecond;
	private int lastTime;
	
	public Buildings[] buildings = { 
		    new Buildings("clicker", 0.1, 15, 0), new Buildings("grandma", 1.0, 100, 0), 
		    new Buildings("farm", 10.0, 500, 0), new Buildings("mine", 50.0, 5000, 0),
		    new Buildings("factory", 100.0, 7500, 0), new Buildings("cookie coder", 250.0, 10000, 0),
		    new Buildings("hacker", 750.0, 50000, 0), new Buildings("clicking bot", 1010.0, 99999, 0),
		    new Buildings("AI", 1111.0, 101010, 0),
		    new Buildings("mouse", 1.0, -1.0, 1)
		};
	public Upgrades[] upgrades = { 
			    new Upgrades("upgrade clicker", 2.0, 100, false, buildings[0]),
			    new Upgrades("upgrade grandma", 2.0, 500, false, buildings[1]),
			    new Upgrades("upgrade farm", 2.0, 1000, false, buildings[2]),
			    new Upgrades("upgrade mine", 2.0, 17500, false, buildings[3]),
			    new Upgrades("upgrade factory", 2.0, 30000, false, buildings[4]),
			    new Upgrades("upgrade cookie coder", 2.0, 25000, false, buildings[5]),
			    new Upgrades("upgrade hacker", 2.0, 1111111, false, buildings[6]),
			    new Upgrades("upgrade clicking bot", 2.0, 234432, false, buildings[7]),
			    new Upgrades("upgrade AI", 2.0, 246642, false, buildings[8]),
			    new Upgrades("upgrade mouse", 2.0, 100, false, buildings[buildings.length-1])
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
		cookiesPerSecond = 0;
		for(int i = 0; i < buildings.length-1; i++)
		{
			cookiesPerSecond += buildings[i].getCps()*buildings[i].getAmount();
		}
		cookies += secondsPast()*cookiesPerSecond;
		
		if(c.equalsIgnoreCase("click cookie"))
		{
			cookies += buildings[buildings.length-1].getCps();
			if(upgrades[upgrades.length-1].getBought())
			{
				cookies += cookiesPerSecond*0.1;
			}
		}
		if(c.equalsIgnoreCase("testing cookies"))
		{
			cookies += 1000;
		}

		for(int i = 0; i < buildings.length-1; i++)
		{
			if(c.equalsIgnoreCase(buildings[i].getName()))
			{
				if(cookies >= buildings[i].getCost())
				{
					cookies -= (buildings[i].getCost());
					buildings[i].addAmount(1);
					
					buildings[i].setCost((int)(buildings[i].getCost()*1.15));
					
				}
				else
				System.out.println("you cannot aford this item");
			}
		}
		for(int i = 0; i < upgrades.length; i++)
		{
			if(c.equalsIgnoreCase(upgrades[i].getName()))
			{
				if(cookies >= upgrades[i].getCost() && !upgrades[i].getBought())
				{
					cookies -= (upgrades[i].getCost());
					cookiesPerSecond += upgrades[i].getCps();
					upgrades[i].setBought(true);
					upgrades[i].setCpss();
				}
				else if(upgrades[i].getBought())
				System.out.println("you already purchased this item");
				else
				System.out.println("you cannot aford this item");
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
		for(int i = 0; i < buildings.length-1; i++)
		{
			System.out.println(buildings[i]);
		}
		for(int i = 0; i < upgrades.length; i++)
		{
			if(!upgrades[i].getBought() && upgrades[i].getUpgraded().getAmount() != 0)
			{
			System.out.println(upgrades[i]);
			}
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