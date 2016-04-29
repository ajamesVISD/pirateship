package org.vashonsd.pirateship.structure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.vashonsd.pirateship.Game;
import org.vashonsd.pirateship.io.ConsoleOut;
import org.vashonsd.pirateship.io.StringRead;
import org.vashonsd.pirateship.io.StringWrite;
import org.vashonsd.pirateship.io.UserInput;
import org.vashonsd.pirateship.worldcreator.WorldCreator;


public class Lobby {
	
	public static void modeSelect() throws IOException {

		StringWrite writer = new ConsoleOut();
		StringRead reader = new UserInput();

		
		writer.write("Would you like to create a world, enter an exsisting one, or delete an exsisting one? (Create/List/Delete)");
		String response = reader.read();
		if(response.equalsIgnoreCase("Create")) {
			WorldCreator wc = new WorldCreator();
			World created = wc.worldCreator();
			DatabaseWriter db = new DatabaseWriter();
			db.worldWriter(created);
			Game g = new Game(created.getName());
			g.Run();
			
		}
		else if(response.equalsIgnoreCase("List")) {
			File folder = new File("main/resources");
			File[] listOfFiles = folder.listFiles();
			for(File f: listOfFiles) {
				writer.write(f.getName().replace(".json", ""));
			}
			String resp = reader.read();
			for(File f: listOfFiles) {
				if(resp.contains(f.getName().replace(".json", ""))) {
					Game g = new Game(resp);
					g.Run();
				}
			}
		}
		else if(response.equalsIgnoreCase("Delete")) {
			File folder = new File("main/resources");
			File[] listOfFiles = folder.listFiles();
			for(File f: listOfFiles) {
				writer.write(f.getName().replace(".json", ""));
			}
			String resp = reader.read();
			for(File f: listOfFiles) {
				boolean b = resp.toLowerCase().equalsIgnoreCase(f.getName().replace(".json", ""));
				String nm = f.getName().replace(".json", "");
				if(resp.toLowerCase().equalsIgnoreCase(f.getName().replace(".json", ""))) {
					Lobby.class.getClassLoader().getResource("main/resources/" + f.getName() + ".json");
					try {
						if(f.delete()) {
							writer.write(f.getName().replace(".json", "") + " has been deleted.");
						}
						else {
							writer.write(f.getName().replace(".json", "") + " couldn't be deleted.");
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			Lobby.modeSelect();
		}
	}
}
