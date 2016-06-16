package org.vashonsd.pirateship.runtimeevents.listeners;

import java.io.IOException;
import java.util.EventListener;

import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.runtimeevents.events.PlayerMovementEvent;

public class PlayerMovementListener implements EventListener {

	public void onPlayerMovement(PlayerMovementEvent e) {
		Player p = (Player)e.getSource();
		try {
			StringWrite writer = new ConsoleOut();
			writer.write(p.getName() + " has entered " + e.getCurrentLocation().getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
