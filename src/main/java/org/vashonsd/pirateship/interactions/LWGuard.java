package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.*;

public class LWGuard extends Actor{

	public LWGuard(String name, String typeName, String description, String splash) {
		super(name, "Guard", description, splash);
	}
	
	public LWGuard() {
		super("guard", "guard", "\"No civilians. The king has the city on lock down looking for his gem.\"", "There is a guard here");
		setUp();
	}

	private void setUp() {
		this.enrollCommand(new LWGuardExamine());
		this.setTypeName("guard");
		this.setTypeNamePlural("guards");
	}

}
