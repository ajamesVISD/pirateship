package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;

import java.util.*;

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
		inventory = new Inventory;
	}
	
	public String toString() 
	{
		return "Player: " + name + "is at location: " + current.getName();
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}

	public void changeLocation(Location next) 
	{
		current.leave();
		this.current = next;
		next.enter();
	}
	
	public String locationToString()
	{
		return current.toString();
	}
	
	public Location getLocation()
	{
		return current;
	}
	
}
