package org.vashonsd.pirateship.interactions;

public class Book implements Interactive {

	private String name;
	
	public Book() {
		name = "book";
	}

	public Response handle(Request r) {
		String verb = r.getText();
		Response res = new Response("I'm sorry, I don't know how to " + r.getText() + " a book.");
		if (verb.equals("read")) {
			res.setText("You learn all about the importance of proper hygeine.");
		} else if (verb.equals("examine")) {
			res.setText("The cover reads: \"Ways to Take Care of Yourself\"");
		}
		return res;
	}

	public String getName() {
		return name;
	}

}
