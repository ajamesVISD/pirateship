package org.vashonsd.pirateship.interactions.poke;

public class PokeType {

	private String type;
	private String effective;
	private String weak;
	
	public PokeType(String type)
	{
		this.type = type;
		
		if(type.equalsIgnoreCase("fire"))
			fire();
		else if(type.equalsIgnoreCase("water"))
			water();
		else if(type.equalsIgnoreCase("grass"))
			grass();
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getEffective()
	{
		return effective;
	}
	
	public String getWeak()
	{
		return weak;
	}
	
	public void fire()
	{
		effective = "grass";
		weak = "water";
	}
	
	public void water()
	{
		effective = "fire";
		weak = "grass";
	}
	
	public void grass()
	{
		effective = "water";
		weak = "fire";
	}
	
	public void normal()
	{
		effective = "none";
		weak = "none";
	}
	
	// 1/2 = weak (50% power)
	// 1 = normal (100% power)
	// 2 = effective (200% power)
	public double isEffective(PokeType p)
	{
		if(type.equals(p.getWeak()))
			return 2;
		else if(type.equals(p.getEffective()))
			return 1/2;
		else
			return 1;
	}
	
	public String effString(PokeType p)
	{
		if(type.equals(p.getWeak()))
			return ". It was super effective!";
		else if(type.equals(p.getEffective()))
			return ". It wasn't very effective.";
		else
			return ". It hit.";
	}
}
