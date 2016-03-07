package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;
import org.vashonsd.pirateship.itemstuff.*;

/**
 * The Player is really the keeper of state in this system.
 */

public class Player 
{
	private String name;
	private Inventory inventory;
	private Location current;
	
	public Player(String name) 
	{
		this.name  = name;
		inventory = new Inventory();
	}
	
	public String toString() 
	{
		return "Player: " + name + "is at location: " + current.getName();
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}

	public void setCurrentLocation(Location next) 
	{
		this.current = next;
	}
	
	public String locationToString()
	{
		return current.toString();
	}
	
	public Location getCurrentLocation()
	{
		return current;
	}
	
}
