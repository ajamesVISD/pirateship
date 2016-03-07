package org.vashonsd.pirateship;

/**
 * @author andy
 * This is the main process the game runs on, a bit like the shell prompt in a workstation.
 * In a way it has no special privilege over other processes, just as the Bash prompt in Linux is just
 * a running process. Its privileged role consists only in its assignment in the system.
 * 
 * 
 */
public class MainProcess implements Process {

	public String greet() {
		return "Loading...";
	}

	public String getPrompt() {
		return ">";
	}

	public String Request(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Closing down...";
	}

}
