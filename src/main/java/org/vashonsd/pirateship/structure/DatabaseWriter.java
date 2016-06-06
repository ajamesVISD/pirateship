package org.vashonsd.pirateship.structure;

import java.io.*;
import java.util.*;

import org.vashonsd.pirateship.interactions.Actor;

import com.google.gson.stream.*;

public class DatabaseWriter {

	public static void worldWriter(World world) throws IOException {
		ArrayList<String> writtenids = new ArrayList<String>();
		ArrayList<Location> checkedLocations = new ArrayList<Location>();
		JsonWriter writer;
		String fileName = "src/main/resources/" + world.getName() + ".json";
		File file = new File(fileName);
		if(file.exists()) {
			try {
				file.delete();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if (!file.exists() && file.isDirectory()) {
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
			for (Location l : world.getLocations()) {
				writer.beginObject();
				writer.name("locname").value(l.getName());
				writer.name("description").value(l.getDescription());
				writer.name("splash").value(l.getSplashText());
				writer.name("route_id");
				writer.beginArray();
				for (Route r : l.getRoutes()) {
					writer.value(r.getId());
				}
				writer.endArray();
				writer.name("inventory");
				writer.beginArray();
				for (Actor a : l.getAllItems()) {
					if (!a.isTraversable()) {
						writer.beginObject();
						writer.name("name").value(a.getName());
						writer.name("type").value(a.getTypeName());
						writer.name("description").value(a.getDescription());
						writer.name("splash").value(a.getSplashText());
						writer.endObject();
					}
				}
				writer.endArray();
				writer.endObject();
			}
			writer.endArray();
			writer.name("starting_location").value(world.getStartingLocation().getName());
			writer.name("route");
			writer.beginArray();
			for (Location l : world.getLocations()) {
				for (Route r : l.getRoutes()) {
					if (!(writtenids.contains(r.getId()))) {
						writtenids.add(r.getId());
						writer.beginObject();
						writer.name("id").value(r.getId());
						writer.name("name").value(r.getTypeName());
						writer.name("description").value(r.getDescription());
						writer.name("splash").value(r.getSplashText());
						writer.name("from").value(r.getLocation().getName());
						writer.name("destination").value(
								r.getDestination().getName());
						writer.endObject();
					}
				}
				checkedLocations.add(l);
			}
			writer.endArray();
			writer.endObject();
			System.out.println("World: " + world.getName() + " Saved!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed. IOException");
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Failed. IOException");
			}
		}
	}
}