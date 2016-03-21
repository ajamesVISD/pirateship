package org.vashonsd.pirateship.processes;

public class TalkFactory extends AbstractProcessFactory {
	
	public TalkFactory() {
		setDisplayLevel(DisplayLevel.COMPACT);
		setType(ProcessType.ANYTIME);
	}
	
	public TalkFactory(Enum<DisplayLevel> l) {
		setDisplayLevel(l);
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Talk";
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return "Talk";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A chance to hold a conversation with the air.";
	}

	@Override
	public Process newProcess() {
		// TODO Auto-generated method stub
		return new Talk();
	}

}
