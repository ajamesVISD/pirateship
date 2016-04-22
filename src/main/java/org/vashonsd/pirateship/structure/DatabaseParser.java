package org.vashonsd.pirateship.structure;

import java.io.*;
import java.util.*;

import com.google.gson.stream.*;

public class DatabaseParser {
	private HashMap<String, Location> locations = new HashMap<String, Location>();
	private ArrayList<String> locationNames = new ArrayList<String>();
	private ArrayList<String> ids = new ArrayList<String>();
	private World world;
	private Route current;
	
	private String currentLocation;
	
	public DatabaseParser() {
		super();
	}
	
	public World parseWorld(String worldName) throws IOException {
		DatabaseParser.class.getClassLoader().getResource("main/resources/" + worldName + ".json");
		String fileName = "main/resources/" + worldName + ".json";
		//TODO Is this valid construction?
		JsonReader reader = new JsonReader(new FileReader(fileName));
		reader.beginObject();
		while(reader.hasNext()) {
			String name = reader.nextName();
			if(name.equals("name")) {
				world = new World(reader.nextString());
			}
			else if(name.equals("locations")) {
				reader.beginArray();
				while(reader.hasNext()) {
					reader.beginObject();
					while(reader.hasNext()) {
						name = reader.nextName();
						if(name.equals("locname")) {
							locations.put("foo", new Location(reader.nextString()));
							Location foo = locations.remove("foo");
							currentLocation = foo.getName();
							locationNames.add(currentLocation);
							locations.put(currentLocation, foo);
						}
						else if(name.equals("description")) {
							locations.get(currentLocation).setDescription(reader.nextString());
						}
						else if(name.equals("route_id")) {
							reader.beginArray();
							while(reader.hasNext()) {
								ids.add(reader.nextString());
							}
							reader.endArray();
						}
					}
					reader.endObject();
				}
				reader.endArray();
			}
			else if(name.equals("starting_location")) {
				world.setPointer(reader.nextString());
			}
			else if(name.equals("route")) {
				reader.beginArray();
				while(reader.hasNext()) {
					reader.beginObject();
					while(reader.hasNext()) {
						name = reader.nextName();
						if(name.equals("id")) {
							current = new Route(reader.nextString());
						}
						else if(name.equals("description")) {
							current.setDescription(reader.nextString());
						}
						else if(name.equals("accessor")) {
							current.setAccessor(reader.nextString());
						}
						else if(name.equals("from")) {
							current.setFrom(reader.nextString());
							locations.get(current.getFrom()).addRoute(current);
						}
						else if(name.equals("destination")) {
							current.setDestination(locations.get(reader.nextString()));
						}
					}
					reader.endObject();
				}
				reader.endArray();
			}
		}
		reader.close();
		for(String l: locationNames) {
			world.addLocation(locations.get(l));
		}
	    return world;
	}
}
