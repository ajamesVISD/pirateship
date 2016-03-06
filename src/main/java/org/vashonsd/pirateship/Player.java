package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;


/**
 * @author andy
 * The Player is a minimal representation of a user in the system. To keep track of the user's state,
 * look into the GameState to find the Player matched to a PlayerState.
 */
public class Player {
	private String name;
	private String accountName;
	
	private Process startingProcess;
	
	public Player(String name) {
		super();
		this.name = name;
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
}
