package org.vashonsd.pirateship.structure;

import java.io.*;
import java.util.*;

import com.google.gson.stream.*;

public class DatabaseWriter {
	private ArrayList<Integer> writtenIDs = new ArrayList<Integer>();
	private ArrayList<Location> checkedLocations = new ArrayList<Location>();
	//private HashMap<Route, Integer> routeIDs = new HashMap<Route, Integer>();
	
	public DatabaseWriter() {
		super();
	}
	
	public void worldWriter(World world) throws IOException {
		JsonWriter writer;
		File file = new File("C:/Users/petersen.preston/Desktop/DatabaseTest/worlds.json");
		if(!file.exists() && file.isDirectory()) {
			file.createNewFile();
		}
		writer = new JsonWriter(new FileWriter(file));
		writer.setIndent("  ");
		try {
			writer.beginObject();
			writer.name("name").value(world.getName());
			writer.name("starting_location").value(world.getStartingLocation().getName());
			writer.name("locations");
			writer.beginArray();
			for(Location l: world.getLocations()) {
				writer.beginObject();
				writer.name("name").value(l.getName());
				writer.name("description").value(l.getDescription());
				writer.name("remote_id");
				writer.beginArray();
				for(Route r: l.getRoutes()) {
					writer.value(r.getId());
				}
				writer.endArray();
				writer.endObject();
			}
			writer.endArray();
			writer.name("route");
			writer.beginArray();
			for(Location l: world.getLocations()) {
				for(Route r: l.getRoutes()) {
					if(!(writtenIDs.contains(r.getId()))) {
						writtenIDs.add(r.getId());
					}
				}
				checkedLocations.add(l);
			}
			writer.endArray();
			System.out.println("World: " + world.getName() + " Saved!");
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed. IOException");
		}
		finally {
			try{
				writer.close();
			}
			catch(IOException e) {
				e.printStackTrace();
				System.out.println("Failed. IOException");
			}
		}
	}
}