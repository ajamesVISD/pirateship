package org.vashonsd.pirateship.structure;

import java.util.*;
import org.vashonsd.pirateship.minigame.*;

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
   private Registry games;
   private MinigameRunner runner;
   
   private ArrayList<Route> routes;
   private ArrayList<Integer> route_id;
   
   public Location(String name) {
	   this.name = name;
	   routes = new ArrayList<Route>();
	   games = new Registry();
   }
   
   public Location(String name, String description)
   {
	   this.name = name;
	   this.description = description;
	   
	   routes = new ArrayList<Route>();
	   games = new Registry();
   }
   
   
   public void addGame(MinigameFactory toAdd)
   {
	   games.addGame(toAdd);
   }
   
   public Registry getGames()
   {
	   return games;
   }
   
   public String getName()
   {
	   return this.name;
   }
   public void setDescription(String description) {
	   this.description = description;
   }
   
   public String getDescription() {
	   return this.description;
   }
   
   public ArrayList<Route> getRoutes() {
	   return routes;
   }
   
   public ArrayList<Integer> getRouteIDs() {
	   return route_id;
   }
   
   public void addID(int i) {
	   route_id.add(i);
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
   public void addRoute(String description, String accessor, String from, Location dest)
   {
	   Route r = new Route(description, accessor, from, dest);
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
   
   public String toString()
   {
	   String result = "";
	   result += name + "\n";
	   result += description + "\n";
	   result += routeDescriptions();
	   return result;
   }
}
