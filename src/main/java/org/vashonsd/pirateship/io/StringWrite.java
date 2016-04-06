/**
 * 
 */
package org.vashonsd.pirateship.io;

import java.io.*;

/**
 * @author andy
 * This is a very simplified version of the StringWriter interface from the Java library. The real thing does a better
 * job of dealing with edge cases, opening and closing the stream, and so on.
 * 
 * For now, use this interface to set up any stream that can write output.
 */
public interface StringWrite {
	public void write(String s) throws IOException;
	public void close() throws IOException;

}
