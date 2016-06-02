package org.vashonsd.pirateship.creature;

public interface SpeechBehavior {
	public String approach(Creature c);
	public String idle(Creature c);
	public String speak(Creature c);
	public String exit(Creature c);
	public String failText(Creature c);
}
