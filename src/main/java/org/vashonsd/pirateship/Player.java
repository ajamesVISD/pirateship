package org.vashonsd.pirateship;

import org.vashonsd.pirateship.io.IOConfig;
import org.vashonsd.pirateship.io.StringRead;
import org.vashonsd.pirateship.processes.Process;
import org.vashonsd.pirateship.structure.*;


/**
 * @author andy
 * The Player is a minimal representation of a user in the system. Think of it as keeping all unchanging
 * information about the Player. The changeable information is in the PlayerState object.
 */
public class Player {
	private String name;
	private String accountName;
	
	private Process startingProcess;
	private PlayerState state;
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public PlayerState getState() {
		return state;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Process getStartingProcess() {
		return startingProcess;
	}

	public void setStartingProcess(Process startingProcess) {
		this.startingProcess = startingProcess;
	}
	
	public IOConfig getIo() {
		return state.getIo();
	}
	
	public Location getCurrentLocation() {
		return state.getCurrentLocation();
	}
	
	public Process getCurrentProcess() {
		return state.getCurrentProcess();
	}
}
