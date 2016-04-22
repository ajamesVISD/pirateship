package org.vashonsd.pirateship.structure;

import java.io.File;
import java.io.IOException;

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
		
		writer.write("Would you like to create a world or enter an exsisting one? (Create/List)");
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
			//Needs extra /?
			File folder = new File("main/resources");
			File[] listOfFiles = folder.listFiles();
			for(File f: listOfFiles) {
				writer.write(f.getName().replace(".java", ""));
			}
			String resp = reader.read();
			//TODO Check to make sure world exists
			for(File f: listOfFiles) {
				if(resp.contains(f.getName())) {
					Game g = new Game(resp);
					g.Run();
				}
			}
		}
	}
}
