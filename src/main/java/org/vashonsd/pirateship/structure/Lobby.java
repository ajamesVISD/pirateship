package org.vashonsd.pirateship.structure;

import java.io.File;

import org.vashonsd.pirateship.Game;
import org.vashonsd.pirateship.io.ConsoleOut;
import org.vashonsd.pirateship.io.StringRead;
import org.vashonsd.pirateship.io.StringWrite;
import org.vashonsd.pirateship.io.UserInput;

public class Lobby {
	
	public static void modeSelect() {

		StringWrite writer = new ConsoleOut();
		StringRead reader = new UserInput();
		
		writer.write("Would you like to create a world or enter an exsisting one? (Create/List)");
		String response = reader.read();
		if(reader.read().equalsIgnoreCase("Create")) {
			WorldCreator wc = new WorldCreator();
			World created = wc.worldCreator();
			DatabaseWriter db = new DatabaseWriter();
			db.worldWriter(created);
			Game g = new Game(created.getName());
		}
		else if(response.equalsIgnoreCase("List")) {
			File folder = new File("main/resources");
			File[] listOfFiles = folder.listFiles();
			for(int i = 0; i < listOfFiles.length; i ++) {
				writer.write(listOfFiles[i].getName().replace(".java", ""));
			}
			String resp = reader.read();
			for(int i = 0; i < listOfFiles.length; i ++) {
				if(resp.equalsIgnoreCase(listOfFiles[i].getName().replace(".java", ""))) {
					Game g = new Game(resp);
					g.Run();
				}
			}
		}
	}
	
}
