package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class LWGemdealer extends Actor {

	public LWGemdealer(String name, String typeName, String description, String splash) {
		super(name, "Gemdealer", description, splash);
	}
	
	public LWGemdealer() {
		super("gemdealer", "gemdealer", "A dirty old man with a green glow coming from his suitcase."
				+ "\n\"I gotta get this little \"gem\" of my hands."
				+ "\nGet it? Man i'm funny. But seriously, take it.\"\n[Glowing gem added to inventory]", "There is a gemdealer.");
		setUp();
	}

	private void setUp() {
		this.enrollCommand(new LWGemdealerExamine());
		this.setTypeName("Gem dealer");
		this.setTypeNamePlural("Gem dealers");
	}
}
