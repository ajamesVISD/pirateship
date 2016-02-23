public class Inventory
{
    private Hashmap<Item, int> inventory;
    
    public Inventory()
    {
        inventory = new Hashmap<Item, int>();    
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
}
