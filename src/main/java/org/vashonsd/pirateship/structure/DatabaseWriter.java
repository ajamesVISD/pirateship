package org.vashonsd.pirateship.structure;

import java.io.*;
import java.util.*;

import com.google.gson.stream.*;

public class DatabaseWriter {
	private ArrayList<String> writtenids = new ArrayList<String>();
	private ArrayList<Location> checkedLocations = new ArrayList<Location>();
	
	public DatabaseWriter() {
		super();
	}
	
	public void worldWriter(World world) throws IOException {
		JsonWriter writer;
		String fileName = "main/resources/" + world.getName() + ".json";
		File file = new File(fileName);
		if(!file.exists() && file.isDirectory()) {
			file.createNewFile();
			System.out.println("Created?");
		}
		writer = new JsonWriter(new FileWriter(file));
		writer.setIndent("  ");
		try {
			writer.beginObject();
			writer.name("name").value(world.getName());
			writer.name("locations");
			writer.beginArray();
			for(Location l: world.getLocations()) {
				writer.beginObject();
				writer.name("locname").value(l.getName());
				writer.name("description").value(l.getDescription());
				writer.name("route_id");
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
					if(!(writtenids.contains(r.getId()))) {
						writtenids.add(r.getId());
						writer.beginObject();
						writer.name("id").value(r.getId());
						writer.name("description").value(r.getDescriptionNA());
						writer.name("accessor").value(r.getAccessor());
						writer.name("from").value(r.getPlayer());
						writer.name("destination").value(r.getDestination().getName());
						writer.endObject();
					}
				}
				checkedLocations.add(l);
			}
			writer.endArray();
			writer.endObject();
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