package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.commands.Inventory;
import org.vashonsd.pirateship.commands.*;
import org.vashonsd.pirateship.commands.easteregg.*;

/**
 * Always is the Actor that is always present. Creepy, I know. In practice, though, Always is just the carrier for
 * commands that always pertain to the user; for example: "inventory".
 * 
 * Always is the final handler when no object can be found for other methods. This means that its handler should *always*
 * return something.
 * 
 * @author andy
 *
 */
public class Always extends Actor {
	
	public Always() {
		super("", "always", "", "");
		this.enrollCommand(new Inventory());
		this.enrollCommand(new Help());
		this.enrollCommand(new Look());
		this.enrollCommand(new ExamineRoom());
		// Dumb easter eggs
		this.enrollCommand(new Backflip());
		this.enrollCommand(new Contemplate());
		this.enrollCommand(new ContemplateLife());
		this.enrollCommand(new Cry());
		this.enrollCommand(new Dance());
		this.enrollCommand(new DanceFab());
		this.enrollCommand(new Depants());
		this.enrollCommand(new Die());
		this.enrollCommand(new DoNothing());
		this.enrollCommand(new Faceplant());
		this.enrollCommand(new Fail());
		this.enrollCommand(new Fly());
		this.enrollCommand(new Jump());
		this.enrollCommand(new Laugh());
		this.enrollCommand(new Live());
		this.enrollCommand(new PickNose());
		this.enrollCommand(new Pose());
		this.enrollCommand(new PoseDram());
		this.enrollCommand(new Rap());
		this.enrollCommand(new Sass());
		this.enrollCommand(new Sing());
		this.enrollCommand(new SingBeaut());
		this.enrollCommand(new Smile());
		this.enrollCommand(new Strut());
		this.enrollCommand(new Suffer());
		this.enrollCommand(new Try());
		this.enrollCommand(new TryHard());
		this.enrollCommand(new TwiddleThumbs());
		this.setVisibility(VisibilityLevel.NEVER);
	}

	@Override
	protected Response handleOtherwise(Request req) {
		return new Response("I'm sorry, I don't understand that command.");
	}
}
