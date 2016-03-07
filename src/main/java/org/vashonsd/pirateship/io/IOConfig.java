package org.vashonsd.pirateship.io;

import java.io.IOException;

/**
 * @author andy
 * IOConfig gives us another layer of abstraction over the two I/O methods which are crucial: reading and writing.
 * The IOConfigFactory will give us different models of I/O; in the meantime, use this factory to read and write.
 */
public class IOConfig {
	private StringRead in;
	private StringWrite out;
	
	public IOConfig(StringRead in, StringWrite out) {
		super();
		this.in = in;
		this.out = out;
	}
	
	public String read() throws IOException {
		return in.read();
	}
	
	public void write(String s) throws IOException {
		out.write(s);
	}
}
