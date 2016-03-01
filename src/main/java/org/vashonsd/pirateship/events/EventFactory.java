package org.vashonsd.pirateship.events;

/*
 * This class is used for returning Events, given a string that represents the Event being asked for.
 * Ex: calling for "hurricane" should return a hurricane, in the form of an Event.
 */
public class EventFactory {
	/*
	 * This is the caller for the event class; like the waitress.
	 * You send it a string like "hurricane", then it will go through 
	 * this list of compacted else if statements and if the string given 
	 * matches, it will return the event in Event form. This allows you
	 * to use the sayName(), sayDescription(), and dealDamage() methods
	 * that are inside of the Event class.
	 */
	public static Event getEvent(String which) {
		if (which.equals("hurricane")) {
			return new Hurricane("Hurricane");
		} else {
			return null;
		}
	}
}
