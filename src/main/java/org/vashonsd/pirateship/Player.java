package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;

import java.util.*;

/**
 * The Player is really the keeper of state in this system.
 */

public class Player 
{
	private String name;
	private Hashmap<Item, int> inventory;
	private Location current;
	
	public Player(String name) 
	{
		this.name  = name;
		inventory = new Hashmap<Item, int>();
	}
	
	public String toString() 
	{
		return "Player: " + name + "is at location: " + current.getName();
	}
	
	public void addItem(Item other, int quan)
	{
		inventory.put(other, quan);
	}
	
	public void removeItem(Item other)
	{
		inventory.remove(other);
	}
	
	public void removeItem(Item other, int quan)
	{
		int cur = inventory.get(other);
		
		inventory.remove(other);
		inventory.put(other, quan);
	}
	
	public void dumpInventory()
	{
		inventory.clear();
	}
	
	public String inventoryToString()
	{
		String toReturn;
		
		for(Item n: inventory.keySet())
			toReturn += "Item: " + n.getName() + "Quantity: " + inventory.get(n) + "\n";
			
		return toReturn;
	}
	
	public Hashmap getInventory()
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
