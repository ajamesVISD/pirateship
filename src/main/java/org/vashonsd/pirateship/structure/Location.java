package org.vashonsd.pirateship.structure;

import java.util.*;

/**
 * @author andy
 * A location represents a single place in our world.
 * It keeps an ArrayList of available routes away from this location to connected locations.
 * 
 * Notice that a location does not "know" how you got there; it does not know what locations can get to it.
 * It can, through the routes list, figure out what destinations it can go to.
 */
public class Location
{
   private String name;
   private String description;
   // Events occuring within location
   //private ArrayList<Event> eventStack;
   // Number of events within location
   // private int size = 0;
   // Tells if player is in location
   
   private ArrayList<Route> routes;
   
   public Location(String name, String description)
   {
	   this.name = name;
	   this.description = description;
	   
	   routes = new ArrayList<Route>();
   }
   
   public String getName()
   {
	   return this.name;
   }
   
   /*
    * Concatenates the descriptions of all the routes into a single stack, with a line break in between
    * each one.
    */
   public String routeDescriptions()
   {
	   String result = "";
	   for (Route s : routes)
	   {
		   result += s.getDescription();
		   if(s.getDistance() > 0)
		   result += " It is " + s.getDistance() + "pr away.";
		   result += "\n";
	   }
	   return result;
   }
   
   /*
    * Use this method if you have not already created the Route; it will create the route for you,
    * using the description and accessor you provide.
    */
   public void addRoute(String description, String accessor, Location dest)
   {
	   Route r = new Route(description, accessor, dest);
	   routes.add(r);
   }
   
   public void addRoute(String description, String accessor, Location dest, double dist)
   {
	   Route r = new Route(description, accessor, dest, dist);
	   routes.add(r);
   }
   /*
    * Use this method if you already have the Route prepared, including a destination Location.
    */
   public void addRoute(Route r)
   {
	   routes.add(r);
   }
   
   /*
    * Figures if a command is valid by looking among the routes, objects and other items advertising their
    * commands.
    * 
    * TO DO: Make this a more general method. For now, we'll just look among the Routes.
    */
   public boolean commandAvailable(String command) {
	   for(Route r: routes) {
		   if (r.getAccessor().equalsIgnoreCase(command)) {
			   return true;
		   }
	   }
	   return false;
   }
   
   /*
    * This looks among the routes, finds the one whose accessor matches the given string,
    * and returns the Location this route takes us to.
    */
   public Location travel(String command) {
	   for(Route r: routes) {
		   if (r.getAccessor().equalsIgnoreCase(command))
		   {
			   return r.getDestination();
		   }
	   }
	   return this;
   }
   
   //Sets size
   /*
   public void setSize(int size)
   {
   	this.size = size;
   }
   */
   
   // Adds event to list of events
   /*
   public void addEvent(Event other)
   {
   	eventStack.add(other);
   	size++;
   }
   */
   
   // Removes event from list of events
   /*
   public void removeEvent(int index)
   {
   	eventStack.remove(index);
   	size--;
   }
   */
   
   public String toString()
   {
   	String toReturn = "";
   	toReturn += "You are in " + name + "\n";
   	toReturn += "You see " + routes.size() + " paths before you: " + "\n";
   	
   	for(int i=0; i<routes.size(); i++)
	   {
		   toReturn += routes.get(i).getDestination().getName() + " (" + routes.get(i).getAccessor() + ")" + "\n";
	   }
	   
	   return toReturn;
   }
}
