package org.vashonsd.pirateship.interactions;

public class East implements Interactive {

	private String name;
	
	public East() {
		name = "east";
	}
	
	public Response handle(Request r) {
		String verb = r.getText();
		Response res = new Response("I'm sorry, I don't know how to " + r.getText() + " east.");
		if (verb.equals("go")) {
			res.setText("You travel east.");
		}
		return res;
	}

	public String getName() {
		return name;
	}
	
}
