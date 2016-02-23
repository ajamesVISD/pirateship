package org.vashonsd.pirateship.io;

import java.io.*;

/**
 * @author andy
 * This is a simplified version of the built-in Java StringReader interface, which has more methods for
 * reading and parsing and gracefully shutting down results.
 * 
 * Future versions may want to read Strings, or []bytes, or even whole objects. The Java interfaces can
 * handle those, they're just more complex.
 * 
 * Notice this interface could be implemented by a file reader, or something that reads a stream from a
 * network, or whatever you want.
 */
public interface StringRead {
	public String read() throws IOException;
}
