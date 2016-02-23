package org.vashonsd.pirateship.io;

import java.io.*;

public class UserInput implements StringRead{
	
	public String read() throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String command = in.readLine();
    	return command;
    }
	
	public void StringReader() {
		
	}
}
