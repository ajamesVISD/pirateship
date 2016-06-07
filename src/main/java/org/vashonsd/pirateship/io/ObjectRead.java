package org.vashonsd.pirateship.io;

import java.io.IOException;

import org.vashonsd.pirateship.interactions.Request;

public interface ObjectRead {
	public ReadObject read() throws IOException;
	public void close() throws IOException;
}
