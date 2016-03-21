package org.vashonsd.pirateship.processes;

public class Talk implements Process {

	@Override
	public String greet() {
		return "Welcome! Enjoy your chance to speak to the air.!";
	}

	@Override
	public String getPrompt() {
		return "Talk";
	}

	@Override
	public ProcessResponse Handle(String s) {
		return new ProcessResponse(true, "I, too am fascinated by " +s);
	}

	@Override
	public String Exit() {
		return "A pleasure speaking with you.";
	}

}
