package org.vashonsd.pirateship.itemstuff;

import java.util.*;

public class ItemType
{
    private ArrayList<String> tags;
//    private EquipBehavior equip;
//    private ValueType value;
//    private EdibleBehavior edible;
//    private StatBehavior stats;
    
    public ItemType(){
        tags = new ArrayList<String>();
        setTags();
    }
    
    public void setTags()
    {
        tags.add("Rusty");
        tags.add("Shiny");
        tags.add("Old");
        tags.add("New");
        tags.add("Cursed");
        tags.add("Blessed");
        tags.add("Light");
        tags.add("Heavy");
    }
}
