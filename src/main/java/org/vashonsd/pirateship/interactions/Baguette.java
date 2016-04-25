package org.vashonsd.pirateship.interactions;

public class Baguette implements Interactive {

	private String name;
	
	public Baguette() {
		name = "baguette";
	}

	public Response handle(Request r) {
		String verb = r.getText();
		Response res = new Response("I'm sorry, I don't know how to " + verb + " a baguette.");
		if (verb.equals("eat")) {
			res.setText("You have eaten a delicious baguette.");
		}
		return res;
	}

	public String getName() {
		return name;
	}
}
