package org.vashonsd.pirateship.structure;

import java.util.*;

/**
 * @author andy
 * A location represents a single place in our world.
 * It keeps an ArrayList available routes away from this location to connected locations.
 */
public class Location
{
   private String name;
   private String description;
   
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
   
   public String routeDescriptions()
   {
	   String result = "";
	   for (Route s : routes)
	   {
		   result += s.getDescription() + "\n";
	   }
	   return result;
   }
   
   public void addRoute(String description, String accessor, Location dest)
   {
	   Route r = new Route(description, accessor, dest);
	   routes.add(r);
   }
   
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
		   if (r.getAccessor().equals(command)) {
			   return true;
		   }
	   }
	   return false;
   }
   
   public Location travel(String command) {
	   for(Route r: routes) {
		   if (r.getAccessor().equals(command))
		   {
			   return r.getDestination();
		   }
	   }
	   return this;
   }
   
   public String toString()
   {
	   String result = "";
	   result += name + "\n";
	   result += description + "\n";
	   result += routeDescriptions();
	   return result;
   }
}