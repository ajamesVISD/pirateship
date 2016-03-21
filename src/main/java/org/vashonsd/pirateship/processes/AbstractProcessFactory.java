package org.vashonsd.pirateship.processes;

public abstract class AbstractProcessFactory {
	public Enum<DisplayLevel> displayLevel;
	public Enum<ProcessType> type;
	
	public Enum<DisplayLevel> getDisplayLevel() {
		return displayLevel;
	}

	public void setDisplayLevel(Enum<DisplayLevel> displayLevel) {
		this.displayLevel = displayLevel;
	}

	public Enum<ProcessType> getType() {
		return type;
	}

	public void setType(Enum<ProcessType> type) {
		this.type = type;
	}

	public abstract String getName();
	
	public abstract String getFullName();
	
	public abstract String getDescription();
	
	public abstract Process newProcess();

}
