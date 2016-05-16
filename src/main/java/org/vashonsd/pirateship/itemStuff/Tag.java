package org.vashonsd.pirateship.itemStuff;

public class Tag 
{
	// Current tag list: "Rusty", "Shiny", "Old", "New", "Cursed", "Blessed", "Light", "Heavy"
	
	private String name;
	private String effect;
	
	public Tag(String name, String effect)
	{
		this.name = name;
		this.effect = effect;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public String getEffect()
	{
		return effect;
	}
	
	public void setEffect(String newEff)
	{
		effect = newEff;
	}
}
