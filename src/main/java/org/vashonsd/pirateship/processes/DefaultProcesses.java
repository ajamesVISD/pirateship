package org.vashonsd.pirateship.processes;

public class DefaultProcesses {
	
	public static ProcessRegistry getBaseProcesses() {
		ProcessRegistry pr = new ProcessRegistry();
		pr.AddFactory(new TalkFactory());
		return pr;
	}
}
