package org.vashonsd.pirateship.structure;

import java.io.*;
import java.util.*;

import org.vashonsd.pirateship.interactions.ItemFactory;

import com.google.gson.stream.*;

public class DatabaseParser {
	// private HashMap<String, Route> routes = new HashMap<String, Route>();
	// private HashMap<Location, ArrayList<String>> locids = new
	// HashMap<Location, ArrayList<String>>();

	public static World parseWorld(String worldName) throws IOException {
		ArrayList<String> locationNames = new ArrayList<String>();
		HashMap<String, Location> locations = new HashMap<String, Location>();
		ArrayList<String> ids = new ArrayList<String>();
		World world = null;
		DatabaseParser.class.getClassLoader().getResource(
				"main/resources/" + worldName + ".json");
		String fileName = "main/resources/" + worldName + ".json";
		JsonReader reader = new JsonReader(new FileReader(fileName));
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("name")) {
				world = new World(reader.nextString());
			} else if (name.equals("locations")) {
				
				reader.beginArray();
				while (reader.hasNext()) {
					reader.beginObject();
					while (reader.hasNext()) {
						String lName = null;
						String lDescription = null;
						String lSplash = null;
						String iName = null;
						String iTypeName = null;
						String iDescription = null;
						String iSplash = null;
						name = reader.nextName();
						if (name.equals("locname")) {
							/*
							 * locations.put("foo", new
							 * Location(reader.nextString())); Location foo =
							 * locations.remove("foo"); currentLocation =
							 * foo.getName();
							 * locationNames.add(currentLocation);
							 * locations.put(currentLocation, foo);
							 */
							lName = reader.nextString();
							locationNames.add(lName);
						} else if (name.equals("description")) {
							// locations.get(currentLocation).setDescription(reader.nextString());
							lDescription = reader.nextString();
						} else if (name.equals("splash")) {
							// locations.get(currentLocation).setDescription(reader.nextString());
							lSplash = reader.nextString();
						} else if (name.equals("route_id")) {
							reader.beginArray();
							while (reader.hasNext()) {
								String curID = reader.nextString();
								if (!ids.contains(curID)) {
									ids.add(curID);
								}
							}
							reader.endArray();
						}
						else if(name.equals("inventory")) {
							reader.beginArray();
							while (reader.hasNext()) {
								reader.beginObject();
								if(name.equals("name")) {
									iName = reader.nextString();
								} else if(name.equals("type")) {
									iTypeName = reader.nextString();
								} else if(name.equals("description")) {
									iDescription = reader.nextString();
								} else if(name.equals("splash")) {
									iSplash = reader.nextString();
								}
								reader.endObject();
							}
							reader.endArray();
						}
						locations.put(lName, new Location(lName, lDescription,
								lSplash));
						locations.get(lName).addToInventory(ItemFactory.newActor(iName, iTypeName, iDescription, iSplash));
						// locids.put(locations.get(lName), ids);
					}
					reader.endObject();
				}
				reader.endArray();
			} else if (name.equals("starting_location")) {
				world.setPointer(locations.get(reader.nextString()));
			} else if (name.equals("route")) {
				reader.beginArray();
				while (reader.hasNext()) {
					reader.beginObject();
					String id = null;
					String rName = null;
					String rDescription = null;
					String rSplash = null;
					String rWhereIs = null;
					Location rDestination = null;
					while (reader.hasNext()) {
						name = reader.nextName();
						if (name.equals("id")) {
							id = reader.nextString();
						} else if (name.equals("name")) {
							rName = reader.nextString();
						} else if (name.equals("description")) {
							rDescription = reader.nextString();
						} else if (name.equals("splash")) {
							rSplash = reader.nextString();
						} else if (name.equals("from")) {
							rWhereIs = reader.nextString();
						} else if (name.equals("destination")) {
							rDestination = locations.get(reader.nextString());
						}
					}
					locations.get(rWhereIs).addRoute(rName, rDescription,
							rSplash, rDestination);
					reader.endObject();
				}
				reader.endArray();
			}
		}
		reader.close();
		for (String l : locationNames) {
			world.addLocation(locations.get(l));
		}
		return world;
	}
}
