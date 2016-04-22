package org.vashonsd.pirateship.interactions;

import java.util.HashMap;

public class Inventorie 
{
	private HashMap<String, Handleable> reponders;
	
	public Response commandMe(String s)
	{
		//our example is "read book"
		//we split this to get "read" and "book"
		//turns s into a Request.
		//Get "book" out of the string somehow.
		Handleable theThing = responders.get("baguette");
		return theThing.handle("eat");
	}
}