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
	private String messageRecipient;

	/**
	 * @param args
	 */
	
	public Message()
	{
		
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
	
	public void createMessage() throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Insert the message here: ");
		messageText=in.readLine();
		System.out.print("Insert the recipient: ");
		messageRecipient = in.readLine();
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
