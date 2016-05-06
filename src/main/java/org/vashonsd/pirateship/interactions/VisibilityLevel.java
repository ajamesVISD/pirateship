package org.vashonsd.pirateship.interactions;

/**
 * An enum representing how visible an object in. Objects in plain sight are at EXAMINE.
 * 
 * As with many things, this is what you make of it. Until this is implemented, this is just constants
 * in a sequence. It allows us to descriptively compare visibility levels, so that we can, for example,
 * say if something is "below" EXAMINE level.
 */
public enum VisibilityLevel {
	NEVER, HELP, EXAMINE, ALWAYS
}
