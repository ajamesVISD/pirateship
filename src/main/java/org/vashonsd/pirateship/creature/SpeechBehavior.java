package org.vashonsd.pirateship.creature;

public interface SpeechBehavior {
	/**
	 * The text that introduces how the creature speaks,
	 * or the text that is displayed when a creature's speech behavior changes
	 */
	public String intro(Creature c);
	/**
	 * The text that is displayed upon first encountering a creature
	 */
	public String approach(Creature c);
	/**
	 * The text that is displayed when a creature is idle,
	 * or the flavor text in between turns when interacting with a creature
	 */
	public String idle(Creature c);
	/**
	 * The creature response when spoken to
	 */
	public String speak(Creature c);
	/**
	 * The text displayed upon leaving a creature
	 */
	public String exit(Creature c);
	/**
	 * The text displayed upon entering a command the creature/computer
	 * does not understand
	 */
	public String failText(Creature c);
}
