/**
 * 
 */
package org.vashonsd.pirateship.message;

import java.util.*;

/**
 * @author Gabriele
 *
 */
public class Message {
	private String messageText;
	private String messageRecipient;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Message(String text)
	{
		messageText = text;
		messageRecipient = "everyone";

	}
	
	public Message(String text, String recipient)
	{
		messageText = text;
		messageRecipient = recipient;
	}
	
	public String getMessageText()
	{
		return messageText;
	}
	
	public String getMessageRecipient()
	{
		return messageRecipient;
	}
	
	public void setMessageText(String text)
	{
		messageText = text;
	}
	
	public void setMessageRecipient(String recipient)
	{
		messageRecipient = recipient;
	}
	
	public void printMessageText()
	{
		System.out.println(messageText);
	}
	
	public void printMessage()
	{
		System.out.println("Message to "+messageRecipient+": "+messageText);
	}

}
