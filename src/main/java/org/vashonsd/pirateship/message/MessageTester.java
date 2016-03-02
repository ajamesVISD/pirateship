package org.vashonsd.pirateship.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Message m = createMessage();
		System.out.println(m);
	}

	public static Message createMessage() throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Insert the message here: ");
		String messageText=in.readLine();
		System.out.print("Insert the subject: ");
		String messageSubject = in.readLine();
		return new Message(messageSubject, messageText);
	}
}
