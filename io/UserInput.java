package org.vashonsd.pirateship.io;

import java.io.*;

/**
 * @author andy
 * This class implements our StringRead interface, which means it can read(), returning a String
 * and potentially throwing an IOException in the process.
 * 
 * Use this as the simple class from reading from the console.
 */
public class UserInput implements StringRead{
	
	public String read() throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String command = in.readLine();
    	return command;
    }
	
	public void StringReader() {
		
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
