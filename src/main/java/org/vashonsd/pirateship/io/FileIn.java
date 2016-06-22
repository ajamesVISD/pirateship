package org.vashonsd.pirateship.io;
import java.io.*;

public class FileIn implements StringRead {
	
	private File file;
	private BufferedReader reader;
	
	public FileIn(String fileName) throws IOException {
		file = new File(fileName);
		reader = new BufferedReader(new FileReader(file));
	}
	//FileIn requires the fileName as a string, it should equal the name of the 
	//text file you are using to record input.
	
	//You must create a text file in the same folder as your src.
	//Ex; Z:\git\"Your Branch Name"\.git
	
	public String read() throws IOException {
		return reader.readLine();
	}
	
	public void close() throws IOException {
		reader.close();
	}
}
