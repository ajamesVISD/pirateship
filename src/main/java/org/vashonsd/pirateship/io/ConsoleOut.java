package org.vashonsd.pirateship.io;

import java.io.IOException;

/**
 * @author andy
 * This satisfies our StringWrite interface, allowing us to send a String back to the console.
 * 
 */
public class ConsoleOut implements StringWrite {

	public void write(String s) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
