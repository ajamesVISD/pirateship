package org.vashonsd.pirateship.io;

import java.io.IOException;

public class ConsoleOut implements StringWrite {

	public void write(String s) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
