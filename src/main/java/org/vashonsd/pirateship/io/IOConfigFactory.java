package org.vashonsd.pirateship.io;

public class IOConfigFactory {
	
	public static IOConfig consoleIO() {
		return new IOConfig(new UserInput(), new ConsoleOut());
	}
}
