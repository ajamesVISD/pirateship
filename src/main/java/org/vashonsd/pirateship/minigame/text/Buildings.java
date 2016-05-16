package org.vashonsd.pirateship.minigame.text;

public class Buildings 
{
	double cps;
	String name;
	double cost;
	int amount;
	public Buildings(String name, double cps, double cost, int amount)
	{
		this.name = name;
		this.cps = cps;
		this.cost = cost;
		this.amount = amount;
	}
	public String getName()
	{
		return name;
	}
	public double getCps()
	{
		return cps;
	}
	public void setCps(double cp)
	{
		cps = cp;
	}
	
	public double getCost()
	{
		return cost;
	}
	public int getAmount()
	{
		return amount;
	}
	
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public void addAmount(int x)
	{
		amount += x;
	}
	
	public String toString()
	{
		return amount + " " + name + "|cost: " + cost;
	}
}
