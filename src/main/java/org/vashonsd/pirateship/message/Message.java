/**
 * 
 */
package org.vashonsd.pirateship.message;

import java.util.*;
import java.io.*;

/**
 * @author Gabriele
 * This class creates a simple message with no information about the world outside it.
 */
public class Message {
	private String messageText;
	private String messageSubject;

	/**
	 * @param args
	 */
	
	public Message()
	{
		
	}
	
	public Message(String text)
	{
		messageText = text;

	}
	
	
	public Message(String messageSubject, String messageText) {
		super();
		this.messageText = messageText;
		this.messageSubject = messageSubject;
	}

	public String getSubject() {
		return messageSubject;
	}

	public void setSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	
	public String getMessageText()
	{
		return messageText;
	}
	
	public void setMessageText(String text)
	{
		messageText = text;
	}
	
	public String printMessageText()
	{
		return messageText;
	}
	
	public String toString()
	{
		return "Subject: " + messageSubject + "\nMessage: " + messageText;
	}

}
