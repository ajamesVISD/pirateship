package org.vashonsd.pirateship.item;

import java.util.*;

import org.vashonsd.pirateship.interactions.Response;
import org.vashonsd.pirateship.item.typeInterfaces.ReadBehavior;

public class ItemType
{
    private ArrayList<Tag> tags;
    private ArrayList<Tag> tagList; 
// Current tag list: "Rusty", "Shiny", "Old", "New", "Cursed", "Blessed", "Light", "Heavy"
//    private EquipBehavior equip;
//    private ValueType value;
//    private EdibleBehavior edible;
//    private StatBehavior stats;
//	  private ModBehavior mods;
	private ReadBehavior readable;
	private String r;
    
    public ItemType()
    {
        tags = new ArrayList<Tag>();
        setTags();
        r = "";
    }
    
    public void setTags()
    {
    	Tag rusty = new Tag("Rusty", "Damage -2, Poison Damage +1");
    	tagList.add(rusty);
    	Tag shiny = new Tag("Shiny", "Damage +1");
    	tagList.add(shiny);
    	Tag old = new Tag("Old", "Durability -2");
    	tagList.add(old);
    	Tag neww = new Tag("New", "Durability +1");
    	tagList.add(neww);
    	Tag cursed = new Tag("Cursed", "Luck -2");
    	tagList.add(cursed);
    	Tag blessed = new Tag("Blessed", "Luck +1");
    	tagList.add(blessed);
    	Tag light = new Tag("Light", "Weight -1");
    	tagList.add(light);
    	Tag heavy = new Tag("Heavy", "Weight +2");
    	tagList.add(heavy);
    }
    
    public void addTag(String name)
    {
    	int i = 0;
    	boolean add = false;
    	
    	for(Tag t: tagList)
    	{
    		i++;
    		
    		if(name.equals(t.getName()))
    		{
    			add = true;
    			break;
    		}
    	}
    	
    	if(add)
    	{
    		tags.add(tagList.get(i));
    	}
    }
    
    public void removeTag(Tag tag)
    {
    	tags.remove(tag);
    }
    
    public void read()
    {
    	
    }
    
    public void setRead(String r)
    {
    	this.r = r;
    }
}
