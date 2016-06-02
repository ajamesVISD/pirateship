package org.vashonsd.pirateship.io;
import java.io.*;

public class FileOut implements StringWrite {
	
	private File file;
	private FileWriter writer;
	
	public FileOut(String fileName) throws IOException {
		file = new File(fileName);
		writer = new FileWriter(file);
	}
	//FileOut requires the fileName as a string, it should equal the name of the 
	//text file you are using to record output.
	
	public void write(String s) throws IOException {
		s = s.replace("\n", "\r\n");
		writer.write(s, 0, s.length());
		writer.write("\r\n", 0, 2);
	}

	public void close() throws IOException {
		writer.close();
	}	
}
