package org.vashonsd.pirateship.minigame;

public class Upgrades 
{
	double cps;
	String name;
	double cost;
	boolean amount;
	Buildings upgraded;
	public Upgrades(String name, double cps, double cost, boolean bought, Buildings b)
	{
		this.name = name;
		this.cps = cps;
		this.cost = cost;
		this.amount = bought;
		upgraded = b;
	}
	public String getName()
	{
		return name;
	}
	public Buildings getUpgraded()
	{
		return upgraded;
	}
	public double getCps()
	{
		return cps;
	}
	public void setCpss()
	{
		upgraded.setCps(cps*upgraded.getCps());
	}
	
	public double getCost()
	{
		return cost;
	}
	public boolean getBought()
	{
		return amount;
	}
	public void setBought(boolean b)
	{
		amount = b;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	public String toString()
	{
		return name + ": " + cost;
	}
}
