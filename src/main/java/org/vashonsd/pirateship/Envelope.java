package org.vashonsd.pirateship;

import org.vashonsd.pirateship.message.*;


/**
 * @author Gabriele
 * Use this class to generate messages, attach Players as the sender and recipient, and 
 */
public class Envelope {
	private Player sender;
	private Player recipient;
	private Message message;
	
	public Envelope(Player recipient, Message message) {
		super();
		this.recipient = recipient;
		this.message = message;
	}

	public Envelope(Player sender, Player recipient, Message message) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
	}

	public Player getSender() {
		return sender;
	}

	public void setSender(Player sender) {
		this.sender = sender;
	}

	public Player getRecipient() {
		return recipient;
	}

	public void setRecipient(Player recipient) {
		this.recipient = recipient;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
