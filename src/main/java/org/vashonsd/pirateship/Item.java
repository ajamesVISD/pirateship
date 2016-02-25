public class Item {
	//Initializing the item variables
	private String name;
	private String description;
	private double weight;

	/**
	 * Constructor for an Item.
	 * @param name
	 * @param description
	 * @param weight
	 */
	public Item(String name, String description, int weight) {
		this.name = name; 
		this.description = description;
		this.weight = weight;
	}

	// Sets description
	public void setDescription(String description) {
		this.description = description;
	}

	// Method returning the Description of the item.
	public String getDescription() {
		return description;
	}

	// Sets name
	public void setName(String name) {
		this.name = name;
	}

	// Method returning the Name of the item.
	public String getName() {
		return name;
	}
	
	// Sets weight of item
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	// Method returning the Weight of the item.
	public double getWeight() {
		return weight;
	}
	
	// Removes quantity of item from player inventory.
	public void useItem(Item item, Player other, int quantity) {
		other.removeItem(item, quantity);
	}
	
}
