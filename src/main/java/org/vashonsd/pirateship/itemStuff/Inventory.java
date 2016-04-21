package org.vashonsd.pirateship.itemStuff;

import java.util.*;

public class Inventory
{
    private HashMap<Item, Integer> inventory;
    
    public Inventory()
    {
        inventory = new HashMap<Item, Integer>();
        itemSet();
    }
    
    public void addNewItem(Item other, int quan)
	{
		inventory.put(other, quan);
	}
    
    public void addItem(Item other, int quan)
    {
    	inventory.remove(other);
    	inventory.put(other, quan);
    }
	
	public void removeItem(Item other)
	{
		inventory.remove(other);
	}
	
	public void removeItem(Item other, int quan)
	{
		inventory.remove(other);
		inventory.put(other, quan);
	}
	
	public void dumpInventory()
	{
		inventory.clear();
		itemSet();
	}
	
	public String inventoryToString()
	{
		String toReturn = "";
		
		for(Item n: inventory.keySet())
		{
			if(inventory.get(n) >= 1)
				toReturn += "Item: " + n.getName() + "Quantity: " + inventory.get(n) + "\n";
		}
			
		return toReturn;
	}
	
	public boolean hasItem(Item t)
	{
		return(inventory.containsKey(t) && inventory.get(t)>0);
	}
	
	public boolean hasName(String s)
	{
		for(Item i: inventory.keySet())
		{
			if(i.getName().equals(s))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void itemSet()
	{
		Item knife = new Item("Knife", "A small folding knife", 2);
		Item waterBottle = new Item("Water bottle", "A bottle... of water", 3);
		Item goldCoin = new Item("Gold Coin", "A small gold coin with the queen's face stamped on one side", 0);
		Item pirateHat = new Item("Pirate Hat", "Arrrggghhh", 3);
		Item apple = new Item("Apple", "A shiny red Apple, take a bite deary...", 2);
		Item book = new Item("Book", "This is a book", 1);
		
		addNewItem(knife, 0);
		addNewItem(waterBottle, 0);
		addNewItem(goldCoin, 0);
		addNewItem(pirateHat, 0);
		addNewItem(apple, 0);
		addNewItem(book, 1);
	}
	
}
