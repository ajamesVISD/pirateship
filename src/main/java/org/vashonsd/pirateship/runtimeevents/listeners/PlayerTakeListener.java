package org.vashonsd.pirateship.runtimeevents.listeners;

import java.io.IOException;
import java.util.EventListener;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.io.ConsoleOut;
import org.vashonsd.pirateship.io.StringWrite;
import org.vashonsd.pirateship.runtimeevents.events.PlayerInventoryEvent;

public class PlayerTakeListener implements EventListener{

	public void onPlayerTake(PlayerInventoryEvent e){
		Player p = (Player)e.getSource();
		Actor a = e.getRecipient();
		try {
			StringWrite writer = new ConsoleOut();
			writer.write(p.getName() + " has taken " + a.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
